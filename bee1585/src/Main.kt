import java.util.Scanner


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var n = scanner.nextInt()
    while (n > 0) {
        val x = scanner.nextInt()
        val y = scanner.nextInt()
        val result = x * y / 2
        println("$result cm2")
        n--
    }
}