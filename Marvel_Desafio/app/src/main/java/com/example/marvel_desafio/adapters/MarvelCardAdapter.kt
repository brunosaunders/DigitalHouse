package com.example.marvel_desafio.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel_desafio.R
import com.example.marvel_desafio.databinding.ListItemMarvelCardsBinding
import com.example.marvel_desafio.domain.Comic

class MarvelCardAdapter(val navigateListener: NavigateListener) : RecyclerView.Adapter<MarvelCardAdapter.MarvelCardViewHolder>() {

    var data =  listOf<Comic>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun getItemCount(): Int {
        return data.size ?: 0
    }

    override fun onBindViewHolder(holder: MarvelCardViewHolder, position: Int) {
        val item = data.get(position)

        val path = item.thumbnail?.path
        val extension = item.thumbnail?.extension

        Glide.with(holder.binding.ivMarvelCard.context).load("$path.$extension").into(holder.binding.ivMarvelCard)
        holder.binding.tvMarvelCardNumber.text = "#$position"

        holder.binding.ivMarvelCard.setOnClickListener {
            navigateListener.onClick()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelCardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemMarvelCardsBinding = DataBindingUtil.inflate(inflater, R.layout.list_item_marvel_cards, parent, false)
        return MarvelCardViewHolder(binding)
    }
    class MarvelCardViewHolder(val binding: ListItemMarvelCardsBinding) : RecyclerView.ViewHolder(binding.root)

    class NavigateListener(val action: () -> Unit) {
        fun onClick() = action()
    }
}