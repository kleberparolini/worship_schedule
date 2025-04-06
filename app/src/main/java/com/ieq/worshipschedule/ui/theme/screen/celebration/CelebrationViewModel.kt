package com.ieq.worshipschedule.ui.theme.screen.celebration

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ieq.worshipschedule.domain.model.Celebration
import com.ieq.worshipschedule.domain.repository.CelebrationRepository
import com.ieq.worshipschedule.ui.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CelebrationViewModel @Inject constructor(
    private val repository: CelebrationRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(CelebrationState())
    val state = _state.asStateFlow()

    private val _event = Channel<UiEvent>()
    val event = _event.receiveAsFlow()

    private fun sendEvent(event: UiEvent) {
        viewModelScope.launch {
            _event.send(event)
        }
    }

    init {
        savedStateHandle.get<String>("id")?.let {
            val id = it.toInt()
            viewModelScope.launch {
                repository.getCelebrationById(id)?.let { celebration ->
                    _state.update { celebrationState ->
                        celebrationState.copy(
                            id = celebration.id,
                            name = celebration.name,
                            ministerName = celebration.ministerName,
                            date = celebration.date
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: CelebrationEvent) {
        when (event) {
            is CelebrationEvent.DateChange -> {
                _state.update {
                    it.copy(
                        date = event.value
                    )
                }
            }

            is CelebrationEvent.MinisterNameChange -> {
                _state.update {
                    it.copy(
                        ministerName = event.value
                    )
                }
            }

            is CelebrationEvent.NameChange -> {
                _state.update {
                    it.copy(
                        name = event.value
                    )
                }
            }

            CelebrationEvent.NavigateBack -> sendEvent(UiEvent.NavigateBack)
            CelebrationEvent.Save -> {
                viewModelScope.launch {
                    val state = state.value
                    val celebration = Celebration(
                        id = state.id,
                        name = state.name,
                        ministerName = state.ministerName,
                        date = state.date
                    )

                    if (state.id == null) {
                        repository.insertCelebration(celebration = celebration)
                    } else {
                        repository.updateCelebration(celebration = celebration)
                    }
                    sendEvent(UiEvent.NavigateBack)
                }
            }

            CelebrationEvent.DeleteNote -> {
                viewModelScope.launch {
                    val state = state.value
                    repository.deleteCelebration(
                        celebration = Celebration(
                            id = state.id,
                            name = state.name,
                            ministerName = state.ministerName,
                            date = state.date
                        )
                    )
                }
                sendEvent(UiEvent.NavigateBack)
            }
        }
    }
}