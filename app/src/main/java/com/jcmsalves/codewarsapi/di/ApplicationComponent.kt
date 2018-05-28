package com.jcmsalves.codewarsapi.di

import com.jcmsalves.codewarsapi.CodewarsApp
import com.jcmsalves.codewarsapi.data.di.NetworkModule
import com.jcmsalves.codewarsapi.data.di.RoomModule
import com.jcmsalves.codewarsapi.user.UsersActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,
    NetworkModule::class,
    RepositoryModule::class,
    RoomModule::class,
    MappersModule::class,
    ViewModelsModule::class])
interface ApplicationComponent {
    fun inject(codewarsApp: CodewarsApp)

    fun inject(usersActivity: UsersActivity)
}
