package com.jcmsalves.codewarsapi.data.challenge.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import com.jcmsalves.codewarsapi.data.challenge.local.model.AuthoredChallengeDb
import com.jcmsalves.codewarsapi.data.challenge.local.model.CompletedChallengeDb
import com.jcmsalves.codewarsapi.domain.challenge.AuthoredChallenge
import com.jcmsalves.codewarsapi.domain.challenge.CompletedChallenge
import io.reactivex.Single

@Dao
interface ChallengeDao {

    @Transaction
    @Query("SELECT * FROM authored_challenges WHERE username = :username")
    fun getAuthoredChallenges(username: String): Single<List<AuthoredChallenge>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAuthoredChallenge(authoredChallengeDb: AuthoredChallengeDb)

    @Transaction
    @Query("SELECT * FROM completed_challenges WHERE username = :username")
    fun getCompletedChallenges(username: String): Single<List<CompletedChallenge>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCompletedChallenge(completedChallengeDb: CompletedChallengeDb)
}
