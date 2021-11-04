package com.example.goal.service

import com.example.goal.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginFactory {

    val URL: String = R.string.url_api.toString()

    val loginFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun loginService(): LoginService {
        return loginFactory.create(LoginService::class.java)
    }
}