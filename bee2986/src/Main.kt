import java.util.Scanner


const val PRIME_NUMBER = 1_000_000_007L

fun countWaysToGoDownStairs(n: Int): Long {
    var t1 = 1L
    var t2 = 2L
    var t3 = 4L
    var current: Long = 0L
    if (n < 4) {
        current = when (n) {
            1 -> t1
            2 -> t2
            else -> t3
        }
    } else {
        var i = 4
        while (i <= n) {
            current = ((t3 + t2) % PRIME_NUMBER + t1) % PRIME_NUMBER
            t1 = t2
            t2 = t3
            t3 = current
            i++
        }
    }
    return current
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val res = countWaysToGoDownStairs(n)
    println(res)
}