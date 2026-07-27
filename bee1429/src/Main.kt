import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var value = scanner.nextInt()
    while (value != 0) {
        val str = value.toString()
        var k = str.length
        var sum = 0
        for (digit in str) {
            sum +=  (digit.toInt() - '0'.toInt()) * fatorial(k--)
        }
        println(sum)
        value = scanner.nextInt()
    }
}

fun fatorial(n: Int): Int {
    var product = 1;
    for(i in 2..n) {
        product*=i
    }
    return product
}