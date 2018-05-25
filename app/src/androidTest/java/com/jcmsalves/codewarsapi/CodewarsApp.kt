package com.jcmsalves.codewarsapi

import android.app.Application
import com.jcmsalves.codewarsapi.di.ApplicationModule
import com.jcmsalves.codewarsapi.di.ApplicationComponent

class CodewarsApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .appModule(ApplicationModule(this))
            .build()
    }
}
