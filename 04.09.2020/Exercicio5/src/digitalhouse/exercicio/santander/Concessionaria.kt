package digitalhouse.exercicio.santander

class Concessionaria {
    var registroDeVendas = mutableMapOf<Cliente, Venda>()

    fun registrarVenda(veiculo: Carro, cliente: Cliente, valor: Double) {
        registroDeVendas[cliente] = Venda(cliente, veiculo, valor)
    }
}