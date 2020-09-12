package br.com.digital.house

class RegistroRecebimentos {
    private val registroRecebimentos = mutableListOf<IRecebivel>()

    fun adicionarRecebimento(vararg r: IRecebivel) = r.forEach { registroRecebimentos.add(it) }

    fun apresentarRecebimentos() = registroRecebimentos.forEach { println(it.toString()) }
}