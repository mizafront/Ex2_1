package Ex2

fun main() {
    val action = false
    val previouSumCard = 500_000
    val previouSumVK = 20_000
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
        in 1..2 -> firstCard(sum, action, previouSumCard)
        in 3..4 -> secondCard(sum, previouSumCard)
        5 -> vkPay(sum, previouSumVK)
    }

}

fun firstCard(sum : Int, action : Boolean, previouSumCard : Int) {
    println("""
        От 300р до 75000р в рамках акций комиссия не взымается
        В другие дни комиссия 0.6% + 20р.
    """.trimIndent())

    when{
        (sum + previouSumCard < 600_000) && (sum < 150_000) -> {
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
        else -> println("Превышен лимит отправки")
    }

}

fun secondCard(sum : Int, previouSumCard : Int) {
    println("""
        Переводы с комиссией (минимум 35р)
    """.trimIndent())
    var amount = sum * 100 + 3500

    when{
        (sum + previouSumCard < 600_000) && (sum < 150_000) -> {
            when {
                amount < 3500 -> {
                    amount = sum * 100 + 3500
                    println("При переводе ${sum * 100}  коп. перевод с коммисией $amount  коп.")
                }
                else -> {
                    amount += sum * 100
                    println("При переводе ${sum * 100}  коп. перевод с коммисией $amount  коп.")
                }
            }
        }
        else -> println("Превышен лимит отправки")
    }
}

fun vkPay(sum : Int, previouSumVK : Int){
    when{
        (sum + previouSumVK < 40_000) && (sum < 15_000) -> {
            println("Сумма перевода $sum р.")
        }
        else -> println("Превышен лимит отправки")
    }
}