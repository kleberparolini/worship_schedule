package com.ieq.worshipschedule.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ieq.worshipschedule.data.local.entity.CelebrationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CelebrationDao {
    @Query("SELECT * FROM CelebrationEntity")
    fun getCelebrations(): Flow<List<CelebrationEntity>>

    @Query("SELECT * FROM CelebrationEntity WHERE id = :id")
    suspend fun getCelebrationById(id: Int): CelebrationEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCelebration(celebrationEntity: CelebrationEntity)

    @Delete
    suspend fun deleteCelebration(celebrationEntity: CelebrationEntity)

    @Update
    suspend fun updateCelebration(celebrationEntity: CelebrationEntity)
}