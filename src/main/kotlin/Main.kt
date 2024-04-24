fun main() {
    println("Введите действительные числа, разделяя их пробелом:")
    val inputNumbers = readlnOrNull()
    println(calculate(inputNumbers))
}

fun calculate(line: String?): String {

    if (!line.isNullOrBlank()) {
        val numbers: List<Double>
        try{
            numbers = line.split(" ").map { it.toDouble() }
        } catch (e: NumberFormatException){
            return "Плохой ввод."
        }


        var positiveSum = 0.0
        var positiveCount = 0
        var negativeSum = 0.0
        var negativeCount = 0

        for (number in numbers) {
            if (number > 0) {
                positiveSum += number
                positiveCount++
            } else if (number < 0) {
                negativeSum += number
                negativeCount++
            }
        }

        val positiveAverage = if (positiveCount > 0) positiveSum / positiveCount else 0.0
        val negativeAverage = if (negativeCount > 0) negativeSum / negativeCount else 0.0

        val result = positiveAverage * negativeAverage

        return "Результат: $result"
    } else {
        return "Вы не ввели никаких чисел. Повторите попытку."
    }
}
