package com.example.goal.service

import com.example.goal.model.Cofre
import com.example.goal.model.Conta
import com.example.goal.model.Pessoa
import com.example.goal.model.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {

    //region Login

    fun getLogin(usuario: Usuario, onResult: (Pessoa?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.postLogin(usuario).enqueue(
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

    //endregion

    //region Pessoa

    fun getPessoa(codigoPessoa: Int, onResult: (Pessoa?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        with(retrofit) {
            getPessoa(codigoPessoa)?.enqueue(
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

    fun postPessoa(pessoa : Pessoa, onResult: (Pessoa?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        with(retrofit) {
            postPessoa(pessoa)?.enqueue(
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

    fun putPessoa(codigoPessoa: Int, pessoa : Pessoa, onResult: (Pessoa?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        with(retrofit) {
            putPessoa(codigoPessoa, pessoa)?.enqueue(
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

    //endregion

    //region Conta

    fun getPessoaConta(codigoPessoa: Int, onResult: (Conta?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.getPessoaConta(codigoPessoa)?.enqueue(
            object : Callback<Conta?> {
                override fun onFailure(call: Call<Conta?>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Conta?>, response: Response<Conta?>) {
                    val conta = response.body()
                    onResult(conta)
                }
            }
        )
    }

    //endregion

    //region Cofre

    fun getCofre(codigoPessoa: Int, codigoCofre: Int, onResult: (Cofre?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.getCofre(codigoPessoa, codigoCofre)?.enqueue(
            object : Callback<Cofre?> {
                override fun onFailure(call: Call<Cofre?>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Cofre?>, response: Response<Cofre?>) {
                    val cofre = response.body()
                    onResult(cofre)
                }
            }
        )
    }

    fun postCofre(codigoPessoa: Int, cofre: Cofre,  onResult: (Cofre?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.postCofre(codigoPessoa, cofre)?.enqueue(
            object : Callback<Cofre?> {
                override fun onFailure(call: Call<Cofre?>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Cofre?>, response: Response<Cofre?>) {
                    val cofre = response.body()
                    onResult(cofre)
                }
            }
        )
    }

    fun putCofre(codigoPessoa: Int, codigoCofre: Int, cofre: Cofre, onResult: (Cofre?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.putCofre(codigoPessoa, codigoCofre, cofre)?.enqueue(
            object : Callback<Cofre?> {
                override fun onFailure(call: Call<Cofre?>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Cofre?>, response: Response<Cofre?>) {
                    val cofre = response.body()
                    onResult(cofre)
                }
            }
        )
    }

    fun deleteCofre(codigoPessoa: Int, codigoCofre: Int, onResult: (Boolean?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.deleteCofre(codigoPessoa, codigoCofre)?.enqueue(
            object : Callback<Boolean?> {
                override fun onFailure(call: Call<Boolean?>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Boolean?>, response: Response<Boolean?>) {
                    val resultado = response.body()
                    onResult(resultado)
                }
            }
        )
    }

    //endregion

    //region Promoção

    fun getUsouPromocao(codigoPessoa: Int, onResult: (Boolean?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.getUsouPromocao(codigoPessoa)?.enqueue(
            object : Callback<Boolean?> {
                override fun onFailure(call: Call<Boolean?>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Boolean?>, response: Response<Boolean?>) {
                    val resultado = response.body()
                    onResult(resultado)
                }
            }
        )
    }

    fun postPromocao(codigoPessoa: Int, codigoConta : Int, valor : Double, onResult: (Boolean?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.postPromocao(codigoPessoa, codigoConta, valor)?.enqueue(
            object : Callback<Boolean?> {
                override fun onFailure(call: Call<Boolean?>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Boolean?>, response: Response<Boolean?>) {
                    val resultado = response.body()
                    onResult(resultado)
                }
            }
        )
    }

    //endregion
}