package digitalhouse.exercicio.santander

fun main() {
    val tripe = Tripe(120, 170)
    tripeStatus(tripe)

    tripe.usar()
    tripeStatus(tripe)

    tripe.guardar()
    tripeStatus(tripe)

    tripe.desdobrar()
    tripe.definirAltura(135)
    tripeStatus(tripe)
}

fun tripeStatus(objeto: Tripe) {
    println("Tripé status!")
    println("Dobrado? -> ${if(objeto.dobrado) "sim" else "não"}")
    println("Altura atual -> ${objeto.alturaAtual}")
    println()
}