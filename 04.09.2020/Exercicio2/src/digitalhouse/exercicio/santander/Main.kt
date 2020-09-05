package digitalhouse.exercicio.santander

fun main() {
    val messi = JogadorDeFutebol("Messi")
    val neymar = JogadorDeFutebol("Neymar")
    val sessaoDeTreinamento: SessaoDeTreinamento = SessaoDeTreinamento()

    sessaoDeTreinamento.treinarA(messi)
    messi.status()

    sessaoDeTreinamento.treinarA(neymar)
    neymar.status()
}