package com.example.marvel_desafio.network


import com.example.marvel_desafio.domain.MarvelComics
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://gateway.marvel.com/"
private const val API_KEY = "f85b31c8d52fbec8f47891c5db4335c8"
private const val HASH = "066fb31fd4362fb7bbec5dda05682a04"
private const val TS = "1"

interface MarvelApiService {
    @GET("v1/public/comics?apikey=$API_KEY&hash=$HASH&ts=$TS")
    suspend fun getComics(
        @Query("characters") characterId: Int,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): MarvelComics
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