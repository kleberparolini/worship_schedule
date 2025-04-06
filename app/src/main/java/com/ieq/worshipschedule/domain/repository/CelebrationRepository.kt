package com.ieq.worshipschedule.domain.repository

import com.ieq.worshipschedule.domain.model.Celebration
import kotlinx.coroutines.flow.Flow

interface CelebrationRepository {

    fun getCelebrations(): Flow<List<Celebration>>

    suspend fun getCelebrationById(id: Int): Celebration?

    suspend fun insertCelebration(celebration: Celebration)

    suspend fun deleteCelebration(celebration: Celebration)

    suspend fun updateCelebration(celebration: Celebration)
}