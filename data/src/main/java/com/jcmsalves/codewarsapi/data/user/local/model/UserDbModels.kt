package com.jcmsalves.codewarsapi.data.user.local.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.Relation

class UserAndLanguages {
    @Embedded
    var userDb: UserDb? = null

    @Relation(parentColumn = "username", entityColumn = "username")
    var languages: List<LanguageDb> = ArrayList<LanguageDb>()
}

@Entity(tableName = "users")
data class UserDb(@PrimaryKey val username: String,
                  val name: String?,
                  val leaderboardPosition: Long,
                  @Embedded(prefix = "overall_") val overallRank: RankDb
)

@Entity(tableName = "languages",
    foreignKeys = [(ForeignKey(entity = UserDb::class,
        parentColumns = arrayOf("username"),
        childColumns = arrayOf("username"),
        onDelete = ForeignKey.CASCADE))])
data class LanguageDb(@PrimaryKey(autoGenerate = true) val id: Long = 0,
                      val languageName: String,
                      @Embedded(prefix = "language_") val rank: RankDb,
                      val username: String)


data class RankDb(val score: Int,
                  val color: String,
                  val name: String,
                  val rank: Int = 0)
