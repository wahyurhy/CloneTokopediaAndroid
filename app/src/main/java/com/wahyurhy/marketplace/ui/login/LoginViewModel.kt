package com.wahyurhy.marketplace.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.wahyurhy.marketplace.core.data.repository.AppRepository
import com.wahyurhy.marketplace.core.data.source.remote.request.LoginRequest

class LoginViewModel(val repo: AppRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Hi, I'm Developer"
    }

    val text: LiveData<String> = _text

    fun ubahData() {
        _text.postValue("Ini aku jadi koki")
    }

    fun login(data: LoginRequest) = repo.login(data).asLiveData()

}