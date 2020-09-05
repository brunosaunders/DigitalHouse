package digitalhouse.exercicio.santander

class Tripe(val alturaMinima: Int, val alturaMaxima: Int) {
    var dobrado: Boolean = true
        private set
    var alturaAtual: Int = (alturaMaxima + alturaMinima) / 2
        private set

    fun definirAltura(novaAltura: Int) {
        println("Altura alterada de $alturaAtual para $novaAltura")
        this.alturaAtual = novaAltura
    }

    fun dobrar() {
        when (dobrado) {
            false -> {
                println("dobrando o Tripé...")
                this.dobrado = true
            }
            else -> {
                println("O tripé já está dobrado!")
            }
        }
    }

    fun desdobrar() {
        when (dobrado) {
            true -> {
                println("Desdobrando o tripé...")
                this.dobrado = false
            }
            else -> {
                println("O tripé já está desdobrado")
            }
        }
    }

    fun prontoParaGuardar(): Boolean = dobrado && alturaAtual == alturaMinima

    private fun prontoParaUsar(): Boolean = !dobrado && alturaAtual > (alturaMaxima/2)

    fun guardar() {
        dobrar()
        definirAltura(alturaMinima)
        println("Tripé pronto para guardar? -> ${prontoParaGuardar()}")
        println()
    }

    fun usar() {
        desdobrar()
        definirAltura(160)
        println("Tripé pronto para usar? -> ${prontoParaUsar()}")
        println()
    }
}