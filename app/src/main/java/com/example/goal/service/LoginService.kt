package com.example.goal.service

import com.example.goal.model.Pessoa
import com.example.goal.model.Usuario
import retrofit2.Call
import retrofit2.http.*
import java.util.*


interface LoginService {
    //https://goalapifiap.herokuapp.com/api/login/
    @POST("/login")
    open fun login(@Body userData: Usuario): Call<Pessoa?>
}
