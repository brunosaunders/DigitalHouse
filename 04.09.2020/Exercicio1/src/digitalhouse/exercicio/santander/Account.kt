package digitalhouse.exercicio.santander

class Account(val accountNumber: Int, var balance: Double, val owner: Client) {
    init {
        println("${owner.name}Account created with $balance dollars in balance")
    }

    fun deposit(value: Double) {
        this.balance += value
        println("$value dollars were added. New balance: $balance dollars.")
    }

    fun withdraw(value: Double) {
        when {
            value > balance -> println("You can not withdraw $value dollars.\nInsufficient funds")
            else -> {
                this.balance -= value
                println("$value dollars were withdraw. New balance: $balance")
            }
        }
    }
}