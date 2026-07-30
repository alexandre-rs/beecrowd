import java.util.*

/*
const val ZERO = 0L
const val TEN = 10L

fun reverse(number: Long): Long {
    var reversed: Long = ZERO
    var n = number
    val digitsNumber = if (n == 0L) 1 else floor(log10(n.toDouble())).toInt() + 1
    println("number of digits: $digitsNumber")
    while (n != ZERO) {
        val digit = n % TEN
        reversed = reversed * TEN + digit
        n /= TEN
    }
    return reversed
}
*/
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val line = scanner.nextLine()
    println(line.reversed())
}