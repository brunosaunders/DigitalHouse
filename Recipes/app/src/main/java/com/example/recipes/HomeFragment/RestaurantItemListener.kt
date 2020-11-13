package com.example.recipes.HomeFragment

import com.example.recipes.domain.Restaurant

class RestaurantItemListener(val onClick: (Restaurant) -> Unit) {
    fun itemClicked(restaurant: Restaurant) = onClick(restaurant)
}