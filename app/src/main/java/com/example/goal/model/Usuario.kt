package com.example.goal.model

import com.google.gson.annotations.SerializedName

class Usuario {
    @SerializedName("email")  var email: String
    @SerializedName("senha")  var senha: String

    constructor( email: String, senha : String) {
        this.email = email
        this.senha = senha
    }
}