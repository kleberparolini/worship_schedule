package com.ieq.worshipschedule.data.mapper

import com.ieq.worshipschedule.data.local.entity.CelebrationEntity
import com.ieq.worshipschedule.domain.model.Celebration

fun CelebrationEntity.asExternalModel(): Celebration = Celebration(
    id, name, ministerName, date
)

fun Celebration.toEntity(): CelebrationEntity = CelebrationEntity(
    id, name, ministerName, date
)