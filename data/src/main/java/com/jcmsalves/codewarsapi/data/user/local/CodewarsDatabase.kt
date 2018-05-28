package com.jcmsalves.codewarsapi.data.user.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.jcmsalves.codewarsapi.data.ListConverters
import com.jcmsalves.codewarsapi.data.challenge.local.dao.ChallengeDao
import com.jcmsalves.codewarsapi.data.challenge.local.model.AuthoredChallengeDb
import com.jcmsalves.codewarsapi.data.challenge.local.model.CompletedChallengeDb
import com.jcmsalves.codewarsapi.data.user.local.dao.UserDao
import com.jcmsalves.codewarsapi.data.user.local.model.LanguageDb
import com.jcmsalves.codewarsapi.data.user.local.model.UserDb

@Database(entities = arrayOf(
    UserDb::class,
    LanguageDb::class,
    AuthoredChallengeDb::class,
    CompletedChallengeDb::class),
    version = 1)
@TypeConverters(ListConverters::class)
abstract class CodewarsDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun challengeDao(): ChallengeDao
}
