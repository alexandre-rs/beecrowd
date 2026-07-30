import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val desiredpressure = scanner.nextInt()
    val readpressure = scanner.nextInt()
    println("${desiredpressure - readpressure}")
}