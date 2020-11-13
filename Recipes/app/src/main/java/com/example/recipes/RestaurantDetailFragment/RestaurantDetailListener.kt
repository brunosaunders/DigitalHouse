package com.example.recipes.RestaurantDetailFragment

import com.example.recipes.domain.RestaurantPlate

class RestaurantDetailListener(val onClick: (RestaurantPlate) -> Unit) {
    fun itemClicked(restaurant: RestaurantPlate) = onClick(restaurant)
}