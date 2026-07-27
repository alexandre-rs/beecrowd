import java.util.Scanner

fun mdc(a: Int, b: Int): Int {
    var x = a
    var y = b
    while (y != 0) {
        val temp = y
        y = x % y
        x = temp
    }
    return x
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    while (scanner.hasNext()) {
        val x = scanner.nextInt()
        val y = scanner.nextInt()
        val perimeter = x * 2 + y * 2
        val mdc = mdc(x, y)
        println(perimeter/mdc)
    }
}