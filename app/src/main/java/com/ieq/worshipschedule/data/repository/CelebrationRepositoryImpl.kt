package com.ieq.worshipschedule.data.repository

import com.ieq.worshipschedule.data.local.dao.CelebrationDao
import com.ieq.worshipschedule.data.mapper.asExternalModel
import com.ieq.worshipschedule.data.mapper.toEntity
import com.ieq.worshipschedule.domain.model.Celebration
import com.ieq.worshipschedule.domain.repository.CelebrationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CelebrationRepositoryImpl(private val dao: CelebrationDao) : CelebrationRepository {
    override fun getCelebrations(): Flow<List<Celebration>> {
        return dao.getCelebrations().map { celebrations ->
            celebrations.map {
                it.asExternalModel()
            }
        }
    }

    override suspend fun getCelebrationById(id: Int): Celebration? =
        dao.getCelebrationById(id)?.asExternalModel()

    override suspend fun insertCelebration(celebration: Celebration) {
        dao.insertCelebration(celebration.toEntity())
    }

    override suspend fun deleteCelebration(celebration: Celebration) {
        dao.deleteCelebration(celebration.toEntity())
    }

    override suspend fun updateCelebration(celebration: Celebration) {
        dao.updateCelebration(celebration.toEntity())
    }
}