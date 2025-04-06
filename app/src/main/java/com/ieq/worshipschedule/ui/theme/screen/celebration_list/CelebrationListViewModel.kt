package com.ieq.worshipschedule.ui.theme.screen.celebration_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ieq.worshipschedule.domain.repository.CelebrationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CelebrationListViewModel @Inject constructor(
    repository: CelebrationRepository
) : ViewModel() {
    val celebrationList = repository.getCelebrations()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
}