package com.ieq.worshipschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ieq.worshipschedule.ui.theme.WorshipScheduleTheme
import com.ieq.worshipschedule.ui.theme.screen.celebration.CelebrationScreen
import com.ieq.worshipschedule.ui.theme.screen.celebration.CelebrationViewModel
import com.ieq.worshipschedule.ui.theme.screen.celebration_list.CelebrationListScreen
import com.ieq.worshipschedule.ui.theme.screen.celebration_list.CelebrationListViewModel
import com.ieq.worshipschedule.ui.util.Route
import com.ieq.worshipschedule.ui.util.UiEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorshipScheduleTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Route.celebrationList
                ) {
                    composable(route = Route.celebrationList) {
                        val viewModel = hiltViewModel<CelebrationListViewModel>()
                        val celebrationList by viewModel.celebrationList.collectAsStateWithLifecycle()

                        CelebrationListScreen(
                            celebrationList = celebrationList,
                            onCelebrationClick = {
                                navController.navigate(
                                    Route.celebration.replace(
                                        "{id}",
                                        it.id.toString()
                                    )
                                )
                            },
                            onAddCelebrationEvent = {
                                navController.navigate(Route.celebration)
                            }
                        )
                    }
                    composable(route = Route.celebration) {
                        val viewModel = hiltViewModel<CelebrationViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle()

                        LaunchedEffect(key1 = true) {
                            viewModel.event.collect { event ->
                                when (event) {
                                    is UiEvent.NavigateBack -> {
                                        navController.popBackStack()
                                    }

                                    else -> Unit
                                }

                            }
                        }

                        CelebrationScreen(
                            state = state,
                            onEvent = viewModel::onEvent
                        )
                    }
                }

            }
        }
    }
}