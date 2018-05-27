package com.jcmsalves.codewarsapi.di

import com.jcmsalves.codewarsapi.CodewarsApp
import com.jcmsalves.codewarsapi.MembersActivity
import com.jcmsalves.codewarsapi.data.di.NetworkModule
import com.jcmsalves.codewarsapi.data.di.RoomModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,
    NetworkModule::class,
    RepositoryModule::class,
    RoomModule::class,
    MappersModule::class,
    InteractorsModule::class])
interface ApplicationComponent {
    fun inject(codewarsApp: CodewarsApp)

    fun inject(membersActivity: MembersActivity)
}
