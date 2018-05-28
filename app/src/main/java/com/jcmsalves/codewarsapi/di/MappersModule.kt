package com.jcmsalves.codewarsapi.di

import com.jcmsalves.codewarsapi.data.challenge.mappers.AuthoredChallengeModelToAuthoredChallengeDbMapper
import com.jcmsalves.codewarsapi.data.challenge.mappers.CompletedChallengeModelToCompletedChallengeDbMapper
import com.jcmsalves.codewarsapi.data.user.mappers.UserAndLanguagesToUserMapper
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
    fun provideAuthoredChallengeModelToAuthoredChallengeDbMapper(): AuthoredChallengeModelToAuthoredChallengeDbMapper =
        AuthoredChallengeModelToAuthoredChallengeDbMapper()

    @Provides
    @Singleton
    fun provideCompletedChallengeModelToCompletedChallengeDbMapper(): CompletedChallengeModelToCompletedChallengeDbMapper =
        CompletedChallengeModelToCompletedChallengeDbMapper()

}
