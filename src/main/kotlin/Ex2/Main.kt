package Ex2

fun main() {
    val action = false
    val previouSum = 0
    println("""
        Выберите Тип карты/счёта
        1. Mastercard 
        2. Maestro
        3. Visa
        4. Мир
        5. VK PAY
    """.trimIndent())
    val choice = readLine()!!.toInt()
    println("Введите сумму перевода ")
    val sum = readLine()!!.toInt()

    when(choice){
        in 1..2 -> firstCard(sum, action)
        in 3..4 -> secondCard(sum)
    }

}

fun firstCard(sum : Int, action : Boolean) {
    println("""
        От 300р до 75000р в рамках акций комиссия не взымается
        В другие дни комиссия 0.6% + 20р.
    """.trimIndent())

    when(action){
        true -> {
            if (sum in 300..75000){
                println("Сумма перевода $sum р.")
            }else{
                var amount = ((sum * 100) * 0.006 + 2000).toInt()
                amount += sum * 100
                println("Сумма перевода ${amount / 100} р. ${amount % 100} кооп. ")
            }
        }
        false -> {
            var amount = ((sum * 100) * 0.006 + 2000).toInt()
            amount += sum * 100
            println("Сумма перевода ${amount / 100} р. ${amount % 100} кооп. ")
        }
    }

}

fun secondCard(sum : Int) {
    println("""
        Переводы от 35р. с комиссией 0.75%
    """.trimIndent())

    when{
        sum >= 35 -> {
            var amount = ((sum * 100) * 0.0075).toInt()
            amount += sum * 100
            println("Сумма перевода ${amount / 100} р. ${amount % 100} кооп.")
        }
        else -> println("Перевод от 35р.")

    }

}

fun vkPay(sum : Int){

}