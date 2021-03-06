package com.example.webservices.services

import com.example.webservices.models.Resultado
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Repository {

    @GET("produtos")
    suspend fun getAllProdutosRepo(): Resultado
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://promoios.com.br/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val repository: Repository = retrofit.create(Repository::class.java)