package digitalhouse.exercicio.santander

class JogadorDeFutebol(val nome: String) {
    var energia: Int = 40
    var alegria: Int = 0
    var gols: Int = 0
    var experiencia: Int = 0

    fun fazerGol() {
        this.energia -= 5
        this.alegria += 10
        this.gols += 1
        println("GOOOOL!")
    }

    fun correr() {
        this.energia -= 10
        println("Cansei")
    }

    fun status() {
        println("Status do $nome!")
        println("Energia: $energia")
        println("Alegria: $alegria")
        println("Gols: $gols")
        println("Experiência: $experiencia \n")
    }
}