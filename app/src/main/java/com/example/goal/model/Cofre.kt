package com.example.goal.model

import com.google.gson.annotations.SerializedName

data class Cofre (
    @SerializedName("codigo") var codigo: Int,
    @SerializedName("nome")  var nome: String,
    @SerializedName("descricaoMeta")  var descricaoMeta: String,
    @SerializedName("cadastro")  var cadastro: String,
    @SerializedName("vencimentoMeta")  var vencimentoMeta: String,
    @SerializedName("valorMeta")  var valorMeta: Double,
    @SerializedName("valorTotal")  var valorTotal: Double)


