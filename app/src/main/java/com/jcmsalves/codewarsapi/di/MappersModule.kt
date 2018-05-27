package com.jcmsalves.codewarsapi.di

import com.jcmsalves.codewarsapi.data.user.mappers.UserAndLanguagesToUserMapper
import com.jcmsalves.codewarsapi.data.user.mappers.UserModelToUserDbMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MappersModule {

    @Provides
    @Singleton
    fun provideUserAndLanguagesToUserMapper(): UserAndLanguagesToUserMapper = UserAndLanguagesToUserMapper()

    @Provides
    @Singleton
    fun provideUserModelToUserDbMapper(): UserModelToUserDbMapper = UserModelToUserDbMapper()
}
