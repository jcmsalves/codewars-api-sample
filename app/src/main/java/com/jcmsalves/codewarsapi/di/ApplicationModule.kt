package com.jcmsalves.codewarsapi.di

import android.content.Context
import com.jcmsalves.codewarsapi.CodewarsApp
import com.jcmsalves.codewarsapi.data.RxJava2SchedulersImpl
import com.jcmsalves.codewarsapi.domain.RxJava2Schedulers
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val codewarsApp: CodewarsApp) {

    @Provides
    @Singleton
    fun provideApp(): CodewarsApp = codewarsApp

    @Provides
    @Singleton
    fun provideAppContext(codewarsApp: CodewarsApp): Context = codewarsApp

    @Provides
    fun provideRxJava2Schedulers(): RxJava2Schedulers = RxJava2SchedulersImpl()
}
