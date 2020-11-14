package com.example.recipes.domain

import java.io.Serializable

data class RestaurantPlate(
    val plateName: String,
    val plateImage: Int,
    val plateDescription: String
) : Serializable {
}