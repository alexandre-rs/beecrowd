import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var k = scanner.nextInt()
    while (k > 0) {
        val n = scanner.nextInt()
        val m = scanner.nextInt()
        while (k > 0) {
            val x = scanner.nextInt()
            val y = scanner.nextInt()
            val result = when {
                x == n || y == m -> "divisa"
                x > n && y > m -> "NE"
                x < n && y > m -> "NO"
                x < n -> "SO"
                else -> "SE"
            }
            println(result)
            k--
        }
        k = scanner.nextInt()
    }
}