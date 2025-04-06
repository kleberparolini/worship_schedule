package com.ieq.worshipschedule.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CelebrationEntity(
    @PrimaryKey val id: Int?,
    val name: String,
    val ministerName: String,
    val date: String
)