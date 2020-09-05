package digitalhouse.exercicio.santander

fun main() {
    val clienteBruno = Cliente("Bruno", "Saunders", "senabruno97@hotmail.com")
    val porsche = Carro("Porsche", "911 Carrera", 2015, "Azul", 3200.1)

    val concessionaria = Concessionaria()
    concessionaria.registrarVenda(porsche, clienteBruno, 345082.20)
    println(concessionaria.registroDeVendas)
}