package com.ieq.worshipschedule.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ieq.worshipschedule.data.local.dao.CelebrationDao
import com.ieq.worshipschedule.data.local.entity.CelebrationEntity

@Database(
    version = 1,
    entities = [CelebrationEntity::class]
)

abstract class CelebrationDatabase : RoomDatabase() {

    abstract val dao: CelebrationDao

    companion object {
        const val name = "celebration_db"
    }
}