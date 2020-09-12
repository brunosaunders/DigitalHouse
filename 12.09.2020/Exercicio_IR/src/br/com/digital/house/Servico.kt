package br.com.digital.house

import kotlin.properties.Delegates

class Servico: IRecebivel {
    private lateinit var descricao: String
    private var horas by Delegates.notNull<Int>()
    private var precoHora by Delegates.notNull<Double>()

    fun servico(descricao: String, horas: Int, precoHora: Double) {
        if (horas <= 0) {
            println("Desculpe, serviço não computado, valor de horas = $horas inválido")
            return
        }
        this.descricao = descricao
        this.horas = horas
        this.precoHora = precoHora
    }

    override fun toString(): String = when (horas) {
        1 -> "O serviço de $descricao foi executado por $horas hora," +
                " ao preço de $precoHora/hora, preço total -> ${totalizarReceita()}"
        else -> "O serviço de $descricao foi executado por $horas horas," +
                " ao preço de $precoHora/hora, preço total -> ${totalizarReceita()}"
    }

    override fun totalizarReceita(): Double {
        return horas * precoHora
    }
}