package ex1

fun main() {
    val secondary = 500_000
    agoToText(secondary)
}

fun agoToText(secondary: Int) {
    when {
        secondary < 3600 -> secondaryToMinutes(secondary)
        secondary < 86_400 -> secondaryToHour(secondary)
        secondary >= 86_400 -> secondaryToDay(secondary)
    }
}

fun secondaryToMinutes(secondary: Int) {
    val minutes = secondary / 60
    when {
        minutes % 10 == 1 && minutes != 11 -> {
            println("Был(a) в сети $minutes минуту назад")
        }
        minutes % 10 in 2..4 && minutes / 10 != 1 -> {
            println("Был(a) в сети $minutes минуты назад")
        }
        minutes % 10 in 5..10 && minutes > 1 || minutes in 11..20 -> {
            println("Был(a) в сети $minutes минут назад")
        }
        else -> println("Был(a) в сети только что")
    }

}

fun secondaryToHour(secondary: Int) {
    val hour = secondary / 3600
    when {
        hour % 10 == 1 && hour != 11 -> {
            println("Был(a) в сети $hour час назад")
        }
        hour % 10 in 2..4 && hour / 10 != 1 -> {
            println("Был(a) в сети $hour часa назад")
        }
        hour % 10 in 5..10 && hour > 1 || hour in 11..20 -> {
            println("Был(a) в сети $hour часов назад")
        }
    }
}

fun secondaryToDay(secondary: Int) {
    val day = secondary / 86_400
    when (day) {
        in 1..1 -> {
            println("Был(a) в сети сегодня")
        }
        in 2..2 -> {
            println("Был(a) в сети вчера")
        }
        else -> println("Был(a) в сети давно")
    }
}
