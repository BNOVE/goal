package com.example.goal.model

import com.google.gson.annotations.SerializedName

class Conta {
    @SerializedName("codigo") var codigo: Int
    @SerializedName("agencia")  var agencia: String
    @SerializedName("numero")  var numero: String
    @SerializedName("saldoLivre")  var saldoLivre: Double
    @SerializedName("saldoTotal")  var saldoTotal: Double
    @SerializedName("cofre")  var cofre: List<Cofre>

    constructor(codigo: Int, agencia: String, numero : String, saldoLivre :Double, saldoTotal :Double, cofre: List<Cofre>)   {
        this.codigo = codigo
        this.agencia = agencia
        this.numero = numero
        this.saldoLivre = saldoLivre
        this.saldoTotal = saldoTotal
        this.cofre = cofre
    }
}