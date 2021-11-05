package com.example.goal.service

import com.example.goal.model.Pessoa
import com.example.goal.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RestApi {
    @Headers("Content-Type: application/json")
    @POST("login/")

    fun Login(@Body usuario: Usuario): Call<Pessoa?>
}