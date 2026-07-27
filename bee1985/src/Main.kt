import java.util.Scanner

val menu = mapOf(1001 to 1.5, 1002 to 2.5, 1003 to 3.5, 1004 to 4.5, 1005 to 5.5)

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var p = scanner.nextInt()
    var sum = 0.0
    while (p > 0) {
        sum += menu[scanner.nextInt()]!!*scanner.nextInt()
        p--
    }
    println("%.2f".format(sum))
}

