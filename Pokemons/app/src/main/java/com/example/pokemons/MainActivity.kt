package com.example.pokemons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var pokemonList: List<Pokemon>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = this.supportActionBar

        pokemonList = getPokemons()
        viewPager_pokemon.adapter = PokemonAdapter(this, pokemonList)
        viewPager_pokemon.setPadding(0, 100, 0, 100)
        viewPager_pokemon.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                actionBar?.title = pokemonList[position].name
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })
    }

    fun getPokemons(): List<Pokemon> {
        val pokemon1 = Pokemon(
            1, "Charmander", R.drawable.charmander,
            R.color.colorFire, listOf("Fire"), listOf("Water", "Earth", "Rock")
        )
        val pokemon2 = Pokemon(
            2, "Bulbasaur", R.drawable.bulbasaur,
            R.color.colorGrass, listOf("Grass", "Poison"), listOf("Fire", "Psych", "Ice")
        )
        val pokemon3 = Pokemon(
            3, "Pidgey", R.drawable.pidgey,
            R.color.colorWind, listOf("Normal", "Wind"), listOf("Electric", "Rock", "Ice")
        )
        val pokemon4 = Pokemon(
            4, "Squirtle", R.drawable.squirtle,
            R.color.colorWater, listOf("Water"), listOf("Grass", "Electric")
        )
        return listOf(pokemon1, pokemon2, pokemon3, pokemon4)
    }
}