package ro.mike.tuiasi

import java.util.Scanner
fun main() {
    val bankAccount = BankAccount(
        availableAmount = 120.95,
        cardNumber = "1237894569999",
        cvvCode = 700,
        userName = "Marian Ioan"
    )
    val cardPayment = CardPayment(bankAccount)
    val cashPayment = CashPayment(53.77)
    val stdin = Scanner(System.`in`)

    val filmPrices = mapOf(
        1 to 25.0,
        2 to 23.0,
        3 to 18.0,
        4 to 55.0
    )

    val filmTitles = mapOf(
        1 to "Dune 2",
        2 to "SpiderMan: No way home",
        3 to "StarWars: Fallen Order",
        4 to "Oferta speciala: Family Pack 3 + 1"
    )

    val scanner = Scanner(System.`in`)

    filmTitles.forEach { (key, value) ->
        println("$key. $value Pret ${filmPrices[key]} lei.")
    }

    val choice = scanner.nextInt()
    val price = filmPrices[choice]
    val title = filmTitles[choice]

    if (price != null && title != null) {
        println("Pretul biletului pentru $title va fi de $price lei.")
        println("Introduceti numarul de bilete: ")
        val ticketCount = scanner.nextInt()
        val totalPrice = ticketCount * price
        println("Total: $totalPrice lei.")

        println("Alegeti metoda de plata (cash/card): ")
        val paymentMethod = scanner.next()
        when (paymentMethod) {
            "card" -> {
                println("Inserati detalii card: ")
                print("Nume: ")
                val accountName = stdin.nextLine()
                print("Numar card: ")
                val cardNumber = stdin.nextLine()
                print("CCV: ")
                val ccvCode = stdin.nextInt()
                print("Suma de bani: ")
                val cashAmount = stdin.nextDouble()
                CardPayment(BankAccount(cashAmount, cardNumber, ccvCode, accountName))
                if(totalPrice<=cashAmount){
                    println("Plata a fost realizata cu succes.")
                }else println("Plata esuata.Fonduri insuficiente. ")
            }

            "cash" -> {
                println("Suma de bani cash: ")
                val cashAmount = stdin.nextDouble()
                if(totalPrice<=cashAmount){
                    println("Plata a fost realizata cu succes.")
                }else println("Plata esuata.Fonduri insuficiente. ")
            }
            else -> false
        }
    }
}


