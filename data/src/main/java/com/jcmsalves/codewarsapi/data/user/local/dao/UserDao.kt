package com.jcmsalves.codewarsapi.data.user.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import com.jcmsalves.codewarsapi.data.user.local.model.LanguageDb
import com.jcmsalves.codewarsapi.data.user.local.model.UserAndLanguages
import com.jcmsalves.codewarsapi.data.user.local.model.UserDb
import io.reactivex.Single

@Dao
interface UserDao {

    @Transaction
    @Query("SELECT * FROM users")
    fun getUsers(): Single<MutableList<UserAndLanguages>>

    @Transaction
    @Query("SELECT * FROM Users WHERE username = :username")
    fun getUserByUsername(username: String): Single<UserAndLanguages>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(userDb: UserDb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserLanguage(languageDb: LanguageDb)
}
