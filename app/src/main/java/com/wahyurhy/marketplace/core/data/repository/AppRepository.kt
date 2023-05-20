package com.wahyurhy.marketplace.core.data.repository

import com.inyongtisto.myhelper.extension.logs
import com.wahyurhy.marketplace.core.data.source.local.LocalDataSource
import com.wahyurhy.marketplace.core.data.source.remote.RemoteDataSource
import com.wahyurhy.marketplace.core.data.source.remote.request.LoginRequest
import kotlinx.coroutines.flow.flow

class AppRepository(val local: LocalDataSource, val remote: RemoteDataSource) {

    fun login(data: LoginRequest) = flow {
        try {
            remote.login(data).let {
                if (it.isSuccessful) {
                    val body = it.body()
                    emit(body)
                    logs("Sukses: $body")
                } else {
                    logs("Error : keterangan error")
                }
            }
        } catch (e: Exception) {
            logs("Login Error: ${e.message}")
        }
    }

}