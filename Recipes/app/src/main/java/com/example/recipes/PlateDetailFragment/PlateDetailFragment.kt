package com.example.recipes.PlateDetailFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

        view.findViewById<ImageView>(R.id.imageView_PlateDetailFragment).setImageResource(plateDetail.plateImage)
        view.findViewById<TextView>(R.id.textView_title_PlateDetailFragment).text = plateDetail.plateName
        view.findViewById<TextView>(R.id.textView_description_PlateDetailFragment).text = plateDetail.plateDescription

        view.findViewById<ImageView>(R.id.imageView_upButton_PlateDetailFragment).setOnClickListener {
            findNavController().navigate(PlateDetailFragmentDirections.actionPlateDetailFragmentToHomeFragment())
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context as AppBar).appBar?.hide()
    }

    override fun onDestroy() {
        super.onDestroy()

        (activity as AppBar).appBar?.show()
    }
}