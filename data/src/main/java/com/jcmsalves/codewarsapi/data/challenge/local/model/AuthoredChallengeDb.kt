package com.jcmsalves.codewarsapi.data.challenge.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.jcmsalves.codewarsapi.data.user.local.model.UserDb

@Entity(tableName = "authored_challenges",
    foreignKeys = [(ForeignKey(entity = UserDb::class,
        parentColumns = arrayOf("username"),
        childColumns = arrayOf("username"),
        onDelete = ForeignKey.CASCADE))])
data class AuthoredChallengeDb(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val tags: List<String>,
    val languages: List<String>,
    val username: String)
