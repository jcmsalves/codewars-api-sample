package com.jcmsalves.codewarsapi.data.di

import android.arch.persistence.room.Room
import android.content.Context
import com.jcmsalves.codewarsapi.data.CodewarsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    internal fun providesRoomDatabase(context: Context): CodewarsDatabase {
        return Room.databaseBuilder(context, CodewarsDatabase::class.java, "codewars-db").build()
    }
}
