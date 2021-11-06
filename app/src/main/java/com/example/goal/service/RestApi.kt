package com.example.goal.service

import com.example.goal.model.Cofre
import com.example.goal.model.Conta
import com.example.goal.model.Pessoa
import com.example.goal.model.Usuario
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET


interface RestApi {

    //region Login

    @POST("login/")
    fun postLogin(@Body usuario: Usuario): Call<Pessoa?>
    //endregion

    //region Pessoa

    @POST("pessoa/")
    fun postPessoa(@Body pessoa: Pessoa): Call<Pessoa?>

    @GET("pessoa/{id}")
    fun getPessoa(@Path("id") codigoPessoa: Int?): Call<Pessoa?>?

    @PUT("pessoa/{id}")
    fun putPessoa(@Path("id") codigoPessoa: Int?, @Body pessoa: Pessoa): Call<Pessoa?>

    //endregion

    //region Conta

    @GET("pessoa/{id}/conta/")
    fun getPessoaConta(@Path("id") codigoPessoa: Int?): Call<Conta?>?

    //endregion

    //region Cofre

    @GET("pessoa/{id}/conta/cofre/{idCofre}")
    fun getCofre(@Path("id") codigoPessoa: Int?, @Path("idCofre") idCofre: Int? ): Call<Cofre?>?

    @POST("pessoa/{id}/conta/cofre/")
    fun postCofre(@Path("id") codigoPessoa: Int?, @Body cofre: Cofre): Call<Cofre?>?

    @PUT("pessoa/{id}/conta/cofre/{idCofre}")
    fun putCofre(@Path("id") codigoPessoa: Int?,@Path("idCofre") idCofre: Int?, @Body cofre: Cofre): Call<Cofre?>?

    @DELETE("pessoa/{id}/conta/cofre/{idCofre}")
    fun deleteCofre(@Path("id") codigoPessoa: Int?,@Path("idCofre") idCofre: Int?): Call<Boolean?>?

    //endregion

    //region Promoção

    @POST("pessoa/{id}/conta/{idConta}/promocao/")
    fun postPromocao(@Path("id") id: Int?, @Path("idConta") idConta: Int?, @Body valor: Double): Call<Boolean?>?

    @GET("pessoa/{id}/usouPromocao/")
    fun getUsouPromocao(@Path("id") codigoPessoa: Int?): Call<Boolean?>?


    //endregion

}