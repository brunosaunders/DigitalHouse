package com.example.recipes.RestaurantDetailFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.R
import com.example.recipes.domain.RestaurantPlate

class RestaurantDetailAdapter(val data: List<RestaurantPlate>, val listener: RestaurantDetailListener) : RecyclerView.Adapter<RestaurantDetailAdapter.RestaurantDetailViewHolder>() {

    class RestaurantDetailViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_restaurant_list, parent, false)
        return RestaurantDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantDetailViewHolder, position: Int) {
        val item = data[position]

        holder.view.findViewById<ImageView>(R.id.imageView_plate).setImageResource(item.plateImage)
        holder.view.findViewById<TextView>(R.id.textView_plate_description).text = item.plateName
        holder.view.findViewById<LinearLayout>(R.id.linearLayout_plate_card).setOnClickListener {
            listener.onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}