package com.example.recipes.HomeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.R
import com.example.recipes.domain.Restaurant

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_HomeFragment)
        recyclerView.adapter = RestaurantItemAdapter(getRestaurantList())
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)

        return view
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
}