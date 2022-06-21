val agoHours = 25 //часы
val agoMinuts = 11 //минуты
val agoSeconds = 20 //секунды

fun main() {

    println("Пользователь был " + agoToText(agoToMinuts(), agoToHours()))

}

fun agoToText(formatMinuts: String, formatHours: String): String {

    val totalTime = agoHours * 3600 + agoMinuts * 60 + agoSeconds
    var result = when (totalTime) {
        in 0..60 -> "только что"
        in 60 + 1..3600 -> "$agoMinuts $formatMinuts назад"
        in 3600 + 1..24 * 3600 -> "$agoHours $formatHours назад"
        in 24 * 3600 + 1..24 * 2 * 3600 -> "сегодня"
        in 24 * 2 * 3600 + 1..24 * 3 * 3600 -> "вчера"
        else -> "давно"
    }
    return result
}

fun agoToHours(): String {

    var formatHours = when (agoHours) {

        1, 21 -> "час"
        2, 3, 4, 22, 23, 24 -> "часа"
        else -> "часов"
    }
    return formatHours
}

fun agoToMinuts(): String {

    var formatMinuts = when (agoMinuts) {

        1, 21, 31, 41, 51 -> "минуту"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> "минуты"
        else -> "минут"
    }
    return formatMinuts
}