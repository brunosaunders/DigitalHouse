package digitalhouse.exercicio.santander

class Prova(val dificuldade: Int, val energiaNecessaria: Int) {
    fun podeRealizar(atleta: Atleta): Boolean {
        return atleta.nivel >= dificuldade && atleta.energia >= energiaNecessaria
    }
}