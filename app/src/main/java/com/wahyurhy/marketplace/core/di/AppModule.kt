package com.wahyurhy.marketplace.core.di

import com.wahyurhy.marketplace.core.data.source.local.LocalDataSource
import com.wahyurhy.marketplace.core.data.source.remote.RemoteDataSource
import com.wahyurhy.marketplace.core.data.source.remote.network.ApiConfig
import org.koin.dsl.module

val appModule = module {

    single { ApiConfig.provideApiService }
    single { RemoteDataSource(get()) }
    single { LocalDataSource() }

}