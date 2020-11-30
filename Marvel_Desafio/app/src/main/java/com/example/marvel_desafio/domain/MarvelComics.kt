package com.example.marvel_desafio.domain

import java.io.Serializable


class MarvelComics(
    val data: Results
)

class Results(
    val results: List<Comic>
)


data class Comic(
    val id: Int?,
    val title: String?,
    val description: String?,
    val pageCount: Int?,
    val prices: List<Prices>?,
    val thumbnail: Thumbnail?,
    val dates: List<Dates>?,
    val images: List<Thumbnail>?

) : Serializable

class Dates(
    val type: String,
    val date: String
)

class Thumbnail(
    val path: String,
    val extension: String
)

class Prices(val price: Double)