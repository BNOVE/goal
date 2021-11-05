package com.example.goal.service

import com.example.goal.model.Pessoa
import com.example.goal.model.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RestApiService {

    fun Login(usuario: Usuario, onResult: (Pessoa?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.Login(usuario).enqueue(
            object : Callback<Pessoa?> {
                override fun onFailure(call: Call<Pessoa?>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Pessoa?>, response: Response<Pessoa?>) {
                    val pessoa = response.body()
                    onResult(pessoa)
                }
            }
        )
    }
}