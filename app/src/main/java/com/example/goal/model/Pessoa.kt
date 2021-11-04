package com.example.goal.model

import com.google.gson.annotations.SerializedName

  class Pessoa {
    @SerializedName("codigo") var codigo: Int
    @SerializedName("nome")  var nome: String
    @SerializedName("email")  var email: String

    constructor(codigo: Int,  nome: String, email : String) {
        this.codigo = codigo
        this.nome = nome
        this.email = email
    }
}


