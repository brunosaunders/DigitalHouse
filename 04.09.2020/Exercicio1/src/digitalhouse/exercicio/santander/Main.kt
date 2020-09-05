package digitalhouse.exercicio.santander

fun main() {
    val bruno = Client("Bruno", "Saunders")
    val brunoAccount = Account(1423, 3220.15, bruno)

    val sofiaAccount: Account = Account(1032, 7660.42,
                                            Client("Sofia", "Abravante"))

    println()
    brunoAccount.deposit(152.94)
    brunoAccount.withdraw(2800.00)
    brunoAccount.withdraw(3000.00)

    print("\n")
    sofiaAccount.deposit(6300.42)
    sofiaAccount.withdraw(17921.30)
}