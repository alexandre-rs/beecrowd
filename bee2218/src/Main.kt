import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var t = scanner.nextInt()
    while (t > 0) {
        val n = scanner.nextInt()
        println("${n * (n + 1) / 2 + 1}")
        t--
    }
}