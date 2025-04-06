package com.ieq.worshipschedule.ui.theme.screen.celebration

sealed interface CelebrationEvent {
    data class NameChange(val value: String): CelebrationEvent
    data class MinisterNameChange(val value: String): CelebrationEvent
    data class DateChange(val value: String): CelebrationEvent
    object Save : CelebrationEvent
    object NavigateBack : CelebrationEvent
    object DeleteNote : CelebrationEvent
}