package com.jcmsalves.codewarsapi.data.user.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.jcmsalves.codewarsapi.data.user.local.dao.UserDao
import com.jcmsalves.codewarsapi.data.user.local.model.LanguageDb
import com.jcmsalves.codewarsapi.data.user.local.model.UserDb

@Database(entities = arrayOf(UserDb::class, LanguageDb::class), version = 1)
abstract class CodewarsDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}
