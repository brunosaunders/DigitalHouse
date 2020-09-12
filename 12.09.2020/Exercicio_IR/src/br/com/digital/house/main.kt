package br.com.digital.house

fun main() {
    val registro = RegistroRecebimentos()
    val bicicleta = ItemVenda()
    bicicleta.itemVenda("bicicleta", 3, 754.00)

    val iFood = Servico()
    iFood.servico("delivery do Ifood", 2, 15.02)

    val freelance = Servico()
    freelance.servico("desenvolvimento de app bancário", 220, 250.0)

    registro.adicionarRecebimento(bicicleta, iFood, freelance)
    registro.apresentarRecebimentos()
}