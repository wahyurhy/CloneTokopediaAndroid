package com.wahyurhy.marketplace.utils

import android.app.Application
import com.wahyurhy.marketplace.core.di.appModule
import com.wahyurhy.marketplace.core.di.repositoryModule
import com.wahyurhy.marketplace.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, viewModelModule, repositoryModule))
        }
    }

}