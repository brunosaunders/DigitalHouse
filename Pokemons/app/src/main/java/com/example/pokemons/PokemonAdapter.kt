package com.example.pokemons

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.card_pokemon.view.*

class PokemonAdapter(
    private val context: Context,
    private val pokemonsList: List<Pokemon>
) : PagerAdapter() {

    override fun getCount(): Int {
        return pokemonsList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` == view
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.card_pokemon, container, false)
        val pokemon = pokemonsList[position]

        view.image_pokemon.setImageResource(pokemon.image)
        view.name_pokemon.text = pokemon.name
        view.linearLayout_pokemon.setBackgroundResource(pokemon.color)

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}