package com.jcmsalves.codewarsapi.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.jcmsalves.codewarsapi.domain.user.Language
import com.jcmsalves.codewarsapi.domain.user.User

@Database(entities = arrayOf(User::class, Language::class), version = 1)
abstract class CodewarsDatabase : RoomDatabase() {

}
