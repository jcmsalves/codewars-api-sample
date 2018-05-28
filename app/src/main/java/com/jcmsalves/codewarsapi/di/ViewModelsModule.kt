package com.jcmsalves.codewarsapi.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.jcmsalves.codewarsapi.ViewModelFactory
import com.jcmsalves.codewarsapi.ViewModelKey
import com.jcmsalves.codewarsapi.challenge.authored.viewmodel.AuthoredChallengesViewModel
import com.jcmsalves.codewarsapi.challenge.completed.viewmodel.CompletedChallengesViewModel
import com.jcmsalves.codewarsapi.user.viewmodel.RecentSearchesViewModel
import com.jcmsalves.codewarsapi.user.viewmodel.UserSearchedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    internal abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserSearchedViewModel::class)
    abstract fun bindsUserSearchedViewModel(userSearchedViewModel: UserSearchedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RecentSearchesViewModel::class)
    abstract fun bindsRecentSearchesViewModel(recentSearchesViewModel: RecentSearchesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AuthoredChallengesViewModel::class)
    abstract fun bindsAuthoredChallengesViewModel(authoredChallengesViewModel: AuthoredChallengesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CompletedChallengesViewModel::class)
    abstract fun bindsCompletedChallengesViewModel(completedChallengesViewModel: CompletedChallengesViewModel): ViewModel
}
