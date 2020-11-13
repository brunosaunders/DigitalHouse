package com.example.recipes.RestaurantDetailFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recipes.AppBar
import com.example.recipes.R
import com.example.recipes.domain.Restaurant

class RestaurantDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_restaurant_detail, container, false)

        val restaurant = arguments?.getSerializable("restaurant") as Restaurant




        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context as AppBar).appBar?.hide()
    }
}