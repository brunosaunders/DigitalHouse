package br.com.digitalhouse

fun main() {
    val loteriaDosSonhos = mutableMapOf(
        0 to "Ovos", 1 to "Água", 2 to "Escopeta", 3 to "Cavalo",
        4 to "Dentista", 5 to "Fogo",
    )

    val nomeApelidos = mutableMapOf<String, List<String>>()
    nomeApelidos.put("João", listOf("Juan", "Fissura", "Maromba"))
    nomeApelidos.put("Miguel", listOf("Juan", "Fissura", "Maromba"))
    nomeApelidos.put("Maria", listOf("Wonder Woman", "Mary", "Marilene"))

    val list = mutableListOf<Int>()
    list.addAll(listOf(1,2,3))

}