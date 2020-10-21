package ex2



fun firstCard(sum: Int, action: Boolean, previouSumCard: Int) : String  {
    println("""
        От 300р до 75000р в рамках акций комиссия не взымается
        В другие дни комиссия 0.6% + 20р.
    """.trimIndent())
    val massage : String
    when {
        (sum + previouSumCard < 600_000) && (sum < 150_000) -> {
            when (action) {
                true -> {
                    if (sum in 300..75000) {
                        massage = "Сумма перевода $sum р. 1"
                    } else {
                        var amount = ((sum * 100) * 0.006 + 2000).toInt()
                        amount += sum * 100
                        massage = "Сумма перевода ${amount / 100} р. ${amount % 100} кооп. 2"
                    }
                }
                false -> {
                    var amount = ((sum * 100) * 0.006 + 2000).toInt()
                    amount += sum * 100
                    massage = "Сумма перевода ${amount / 100} р. ${amount % 100} кооп. 3"
                }
            }
        }
        else -> massage = "Превышен лимит отправки"
    }
    return massage

}

fun secondCard(sum: Int, previouSumCard: Int) : String {
    println("""
        Переводы с комиссией (минимум 35р)
    """.trimIndent())
    val massage : String
    if ((sum + previouSumCard < 600_000) && (sum < 150_000)) {
        var amount : Int = (sum * 100 * 0.075).toInt()
        if (amount < 3500) {
            amount = sum * 100 + 3500
            massage = "При переводе ${sum * 100}  коп. перевод с коммисией $amount  коп.1"
        } else {
            amount = ((sum * 100 * 0.075) + (sum * 100)).toInt()
            massage = "При переводе ${sum * 100}  коп. перевод с коммисией $amount  коп.2"
        }
    }
    else massage = "Превышен лимит отправки"
    return massage
}

fun vkPay(sum: Int, previouSumVK: Int) : String {
    val massage : String
    massage = when {
        (sum + previouSumVK < 40_000) && (sum < 15_000) -> {
            "Сумма перевода $sum р."
        }
        else -> "Превышен лимит отправки"
    }
    return massage
}

