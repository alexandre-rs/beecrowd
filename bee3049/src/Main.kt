import java.util.Scanner

const val high = 70
const val base = 160
const val half_area = (high * base) / 2

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val b = scanner.nextInt()
    val t = scanner.nextInt()
    val trapezoidArea = (b + t) / 2 * high
    val res = when {
        trapezoidArea > half_area -> 1
        trapezoidArea < half_area -> 2
        else -> 0
    }
    println(res)
}