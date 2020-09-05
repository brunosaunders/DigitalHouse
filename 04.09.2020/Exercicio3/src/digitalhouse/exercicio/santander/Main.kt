package digitalhouse.exercicio.santander

fun main() {
    val atleta1: Atleta = Atleta("Jon", 3, 20)
    val atleta2: Atleta = Atleta("Carla", 9, 10)

    val provaFacil: Prova = Prova(2, 2)
    val provaDificil: Prova = Prova(7, 8)
    val provaDeResistencia: Prova = Prova(3, 15)

    aplicaAtletaEmProva(atleta1, provaFacil)
    aplicaAtletaEmProva(atleta1, provaDificil)
    aplicaAtletaEmProva(atleta1, provaDeResistencia)

    println()
    aplicaAtletaEmProva(atleta2, provaFacil)
    aplicaAtletaEmProva(atleta2, provaDificil)
    aplicaAtletaEmProva(atleta2, provaDeResistencia)
}

fun aplicaAtletaEmProva(atleta: Atleta, prova: Prova) {
    println("${atleta.nome} consegue realizar a prova? -> ${prova.podeRealizar(atleta)}")
}