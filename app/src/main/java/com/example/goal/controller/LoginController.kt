package com.example.goal.controller

import com.example.goal.model.Pessoa
import com.example.goal.model.Usuario
import com.example.goal.service.LoginFactory
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class LoginController constructor() {



    fun Logar(usuario: String, senha : String) : Pessoa? {



        val call = LoginFactory().loginService().login( Usuario(usuario, senha))

        call.enqueue(object : Callback<Pessoa?> {

            override fun onResponse(call: Call<Pessoa?>, response: Response<Pessoa?>) {

                val pessoa : Pessoa? = response.body()

            }

            override fun onFailure(call: Call<Pessoa?>?, t: Throwable?) {
                val i :Int = 0
            }
        })


        return null

    }
}