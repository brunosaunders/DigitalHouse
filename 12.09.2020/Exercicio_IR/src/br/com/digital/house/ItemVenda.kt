package br.com.digital.house

import kotlin.properties.Delegates

class ItemVenda: IRecebivel {
    private lateinit var produto: String
    private var quantidade by Delegates.notNull<Int>()
    private var valor by Delegates.notNull<Double>()

    fun itemVenda(produto: String, quantidade: Int, valor: Double){
        this.produto = produto
        this.quantidade = quantidade
        this.valor = valor
    }

    override fun toString(): String = when (quantidade) {
        1 -> "$quantidade $produto foi comprado(a) no preço de $valor reais," +
                " preço total -> ${totalizarReceita()}"
        0 -> "nenhum produto foi comprado"
        else -> "$quantidade ${produto}s foram comprados(as) no preço de $valor reais," +
                " preço total -> ${totalizarReceita()}"
    }

    override fun totalizarReceita(): Double = quantidade * valor
}