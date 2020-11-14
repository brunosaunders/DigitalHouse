package com.example.recipes.PlateDetailFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recipes.AppBar
import com.example.recipes.R
import com.example.recipes.domain.RestaurantPlate

class PlateDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_plate_detail, container, false)

        val plateDetail = arguments?.getSerializable("plate") as RestaurantPlate


        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context as AppBar).appBar?.hide()
    }

    override fun onDestroy() {
        super.onDestroy()

        (activity as AppBar).appBar?.hide()
    }
}