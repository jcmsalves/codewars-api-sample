package com.jcmsalves.codewarsapi

import android.app.Application
import com.jcmsalves.codewarsapi.di.ApplicationComponent
import com.jcmsalves.codewarsapi.di.ApplicationModule
import com.jcmsalves.codewarsapi.di.DaggerApplicationComponent

class CodewarsApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}
