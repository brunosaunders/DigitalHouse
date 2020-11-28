package com.example.webservices.models

data class Produto(
    val id_prod: Int,
    val nome_prod: String,
    val valor: String,
    val vol_prod: String,
    val url: String,
    val dt_exp: String
) {
}