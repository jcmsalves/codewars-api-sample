package com.jcmsalves.codewarsapi.data.challenge.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.jcmsalves.codewarsapi.data.user.local.model.UserDb

@Entity(tableName = "completed_challenges",
    foreignKeys = [(ForeignKey(entity = UserDb::class,
        parentColumns = arrayOf("username"),
        childColumns = arrayOf("username"),
        onDelete = ForeignKey.CASCADE))])
data class CompletedChallengeDb(
    @PrimaryKey val id: String,
    val completedAt: String,
    val name: String,
    val completedLanguages: List<String>,
    val slug: String,
    val username: String)
