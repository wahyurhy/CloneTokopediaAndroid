package com.wahyurhy.marketplace.core.data.repository

import com.wahyurhy.marketplace.core.data.source.local.LocalDataSource
import com.wahyurhy.marketplace.core.data.source.remote.RemoteDataSource

class AppRepository(val local: LocalDataSource, val remote: RemoteDataSource)