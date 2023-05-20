package com.wahyurhy.marketplace.core.di

import com.wahyurhy.marketplace.core.data.repository.AppRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { AppRepository(get(), get()) }

}