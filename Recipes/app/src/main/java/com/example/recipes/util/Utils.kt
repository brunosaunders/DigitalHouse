package com.example.recipes.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ScrollView
import com.example.recipes.R
import com.example.recipes.domain.Restaurant
import com.example.recipes.domain.RestaurantPlate
import kotlin.math.absoluteValue

fun hideKeyboardOnScrolled(scrollView: ScrollView) {
    scrollView.setOnScrollChangeListener { view, _, scrollY, _, oldScrollY ->
        when {
            (scrollY - oldScrollY).absoluteValue > 15 -> {
                val imm: InputMethodManager = scrollView.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }
}

fun hideKeyboard(view: View) {
    val imm: InputMethodManager = view.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun getRestaurantList(): List<Restaurant> {
    val restaurant1 = Restaurant(
        "Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo",
        "22:00", R.drawable.image1
    )
    val restaurant2 = Restaurant(
        "Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema",
        "00:00", R.drawable.image4
    )
    val restaurant3 = Restaurant(
        "Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo",
        "00:00", R.drawable.image5
    )
    val restaurant4 = Restaurant(
        "Sí Señor!", "Alameda Jauaperi, 626 - Moema",
        "01:00", R.drawable.image3
    )
    return listOf(restaurant1, restaurant2, restaurant3, restaurant4)
}

fun getRestaurantPlates(): List<RestaurantPlate> {
    val plate01 = RestaurantPlate(
        "Salada com molho Gengibre",
        R.drawable.image4,
        "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."
    )

    return listOf(
        plate01,
        plate01,
        plate01,
        plate01,
        plate01,
        plate01,
        plate01,
        plate01,
        plate01,
        plate01
    )
}