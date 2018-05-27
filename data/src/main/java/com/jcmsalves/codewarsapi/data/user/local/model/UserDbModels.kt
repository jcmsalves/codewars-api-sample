package com.jcmsalves.codewarsapi.data.user.local.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class UserDb(@PrimaryKey val username: String,
                  val name: String,
                  val leaderboardPosition: Long,
                  @Embedded(prefix = "overall_") val overallRank: RankDb,
                  val languages: List<LanguageDb>
)

data class RankDb(val score: Int,
                  val color: String,
                  val name: String,
                  val rank: Int = 0)

@Entity(foreignKeys = [(ForeignKey(entity = UserDb::class,
    parentColumns = arrayOf("username"),
    childColumns = arrayOf("userId"),
    onDelete = ForeignKey.CASCADE))])
data class LanguageDb(val languageName: String,
                      @Embedded(prefix = "language_") val rank: RankDb,
                      val userId: String)
