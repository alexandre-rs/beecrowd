import java.util.Scanner

const val DIVIDER = 100

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var n = scanner.nextInt()
    while (n >= 0) {
        var sum = 0
        var payments = 0
        for (i in 1..n) {
            //ler preços
            val price = scanner.nextInt()
            sum += price
            if (sum % DIVIDER == 0) {
                payments++
            }
        }
        println(payments)
        n = scanner.nextInt()
    }
}