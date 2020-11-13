package com.example.recipes.domain

import java.io.Serializable

data class Restaurant(
    val title: String,
    val description: String,
    val closingTime: String,
    val drawable: Int
) : Serializable {
}