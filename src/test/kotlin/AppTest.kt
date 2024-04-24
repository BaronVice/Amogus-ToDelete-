import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AppTest {

    @Test
    fun emptyString() {
        val expected = "Вы не ввели никаких чисел. Повторите попытку."
        assertEquals(expected, calculate(""))
    }

    @Test
    fun nullString() {
        val expected = "Вы не ввели никаких чисел. Повторите попытку."
        assertEquals(expected, calculate(null))
    }

    @Test
    fun blankString() {
        val expected = "Вы не ввели никаких чисел. Повторите попытку."
        assertEquals(expected, calculate("                     "))
    }

    @Test
    fun allZeros() {
        val expected = "Результат: 0.0"
        assertEquals(expected, calculate("0 0 0 0"))
    }

    @Test
    fun noNegativeOrPositive() {
        val expected = "Результат: 0.0"
        assertEquals(expected, calculate("1 2 3 4 5"))
    }

    @Test
    fun badInput() {
        val expected = "Плохой ввод."
        assertEquals(expected, calculate("1, 2, 3, 4, 5"))
    }

    @Test
    fun valid1() {
        val expected = "Результат: -6.25"
        assertEquals(expected, calculate("1 2 3 4 -1 -2 -3 -4"))
    }

    @Test
    fun valid2() {
        val expected = "Результат: -55165.5"
        assertEquals(expected, calculate("123 -453 123 -444"))
    }

    @Test
    fun stressTest() {
        val expected = "Результат: -2.4691358024691354E111"
        assertEquals(expected, calculate("111111111111111111111111111111111111111111111111111111 -22222222222222222222222222222222222222222222222222222222222"))
    }
}