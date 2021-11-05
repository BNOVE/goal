package com.example.goal.model

import com.google.gson.annotations.SerializedName

data class Usuario (
    @SerializedName("email")  var email: String,
    @SerializedName("senha")  var senha: String
)