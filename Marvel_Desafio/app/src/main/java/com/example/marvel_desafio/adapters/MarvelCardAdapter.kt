package com.example.marvel_desafio.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel_desafio.R

class MarvelCardAdapter(val data: List<String>) : RecyclerView.Adapter<MarvelCardAdapter.MarvelCardViewHolder>() {
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MarvelCardViewHolder, position: Int) {
        val item = data[position]

        holder.iv_cardImage.setImageResource(R.drawable.raster)
        holder.tv_cardNumber.text = item
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_marvel_cards, parent, false)
        return MarvelCardViewHolder(view)
    }
    class MarvelCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iv_cardImage = view.findViewById<ImageView>(R.id.iv_marvelCard)
        val tv_cardNumber = view.findViewById<TextView>(R.id.tv_marvelCardNumber)
    }
}