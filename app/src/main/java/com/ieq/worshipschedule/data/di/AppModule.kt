package com.ieq.worshipschedule.data.di

import android.content.Context
import androidx.room.Room
import com.ieq.worshipschedule.data.local.CelebrationDatabase
import com.ieq.worshipschedule.data.repository.CelebrationRepositoryImpl
import com.ieq.worshipschedule.domain.repository.CelebrationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCelebrationDatabase(@ApplicationContext context: Context) : CelebrationDatabase =
        Room.databaseBuilder(
            context,
            CelebrationDatabase::class.java,
            CelebrationDatabase.name
        ).build()

    @Provides
    @Singleton
    fun provideCelebrationRepository(database: CelebrationDatabase): CelebrationRepository =
        CelebrationRepositoryImpl(dao = database.dao)
}