package digitalhouse.exercicio.santander

class SessaoDeTreinamento {
    val experiencia: Int = 1

    fun treinarA(jogador: JogadorDeFutebol) {
        println("O jogador ${jogador.nome} começou o treinamento!" +
                " Experiência inicial: ${jogador.experiencia}.")
        jogador.correr()
        jogador.fazerGol()
        jogador.correr()
        jogador.experiencia += experiencia
        println("O jogador ${jogador.nome} finalizou o treinamento!" +
                " Experiência final: ${jogador.experiencia} \n")
    }
}