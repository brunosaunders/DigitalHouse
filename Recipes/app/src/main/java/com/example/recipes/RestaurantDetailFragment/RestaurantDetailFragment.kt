package com.example.recipes.RestaurantDetailFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.AppBar
import com.example.recipes.R
import com.example.recipes.domain.Restaurant
import com.example.recipes.util.getRestaurantPlates

class RestaurantDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_restaurant_detail, container, false)

        val restaurant = arguments?.getSerializable("restaurant") as Restaurant

        view.findViewById<ImageView>(R.id.imageView_RestaurantDetailFragment)
            .setImageResource(restaurant.drawable)

        view.findViewById<ImageView>(R.id.imageView_upButton_RestaurantDetailFragment).setOnClickListener {
            findNavController().navigate(R.id.action_restaurantDetailFragment_to_homeFragment)
        }

        val recyclerView =
            view.findViewById<RecyclerView>(R.id.recyclerView_RestaurantDetailFragment)

        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            adapter = RestaurantDetailAdapter(getRestaurantPlates(), RestaurantDetailListener { plateDetail ->
                val action = RestaurantDetailFragmentDirections.actionRestaurantDetailFragmentToPlateDetailFragment(plateDetail)
                findNavController().navigate(action)
            })
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