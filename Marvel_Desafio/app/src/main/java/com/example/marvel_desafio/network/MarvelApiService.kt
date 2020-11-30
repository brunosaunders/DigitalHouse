package com.example.marvel_desafio.network


import com.example.marvel_desafio.domain.MarvelComics
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

val BASE_URL = "https://gateway.marvel.com/"

interface MarvelApiService {
    @GET("v1/public/comics?characters=1009610&apikey=f85b31c8d52fbec8f47891c5db4335c8&hash=066fb31fd4362fb7bbec5dda05682a04&ts=1")
    suspend fun getComics(): MarvelComics
}

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object MarvelApi{
    val retrofitService: MarvelApiService by lazy {
        retrofit.create(MarvelApiService::class.java)
    }
}