package com.example.marvel_desafio.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel_desafio.R
import com.example.marvel_desafio.databinding.ListItemMarvelCardsBinding

class MarvelCardAdapter(val data: List<String>) : RecyclerView.Adapter<MarvelCardAdapter.MarvelCardViewHolder>() {
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MarvelCardViewHolder, position: Int) {
        val item = data[position]

        holder.binding.ivMarvelCard.setImageResource(R.drawable.raster)
        holder.binding.tvMarvelCardNumber.text = item
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelCardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemMarvelCardsBinding = DataBindingUtil.inflate(inflater, R.layout.list_item_marvel_cards, parent, false)
        return MarvelCardViewHolder(binding)
    }
    class MarvelCardViewHolder(val binding: ListItemMarvelCardsBinding) : RecyclerView.ViewHolder(binding.root)
}