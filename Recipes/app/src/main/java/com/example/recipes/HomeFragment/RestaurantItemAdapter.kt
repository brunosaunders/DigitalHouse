package com.example.recipes.HomeFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.R
import com.example.recipes.domain.Restaurant
import kotlinx.android.synthetic.main.list_restaurant_item.view.*

class RestaurantItemAdapter(val data: List<Restaurant>) : RecyclerView.Adapter<RestaurantItemAdapter.RestaurantViewHolder>() {

    class RestaurantViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_restaurant_item, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val item = data[position]

        holder.view.imageView_restaurantItem.setImageResource(item.drawable)
        holder.view.textView_title_restaurantItem.text = item.title
        holder.view.textView_description_restaurantItem.text = item.description
        holder.view.textView_closingTime_restaurantItem.text = item.closingTime
    }

    override fun getItemCount(): Int {
        return data.size
    }
}