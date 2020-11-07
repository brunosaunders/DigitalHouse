package com.example.pokemons

class Pokemon constructor(
    val id: Int, val name: String,
    var image: Int, val color: Int,
    var type: List<String>, var weaknesses: List<String>
) {
    override fun toString(): String {
        return "Pokemon(id=$id, name='$name', image=$image, color=$color, type=$type, weaknesses=$weaknesses)"
    }
}