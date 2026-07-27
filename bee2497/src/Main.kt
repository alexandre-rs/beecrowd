import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var n = scanner.nextInt()
    var count = 1
    while( n > -1) {
        println("Experiment $count: ${n/2} full cycle(s)")
        count++
        n = scanner.nextInt()
    }
}