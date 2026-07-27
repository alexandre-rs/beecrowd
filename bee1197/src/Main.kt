import java.util.Scanner

fun main(args: Array<String> ) {

    val scanner = Scanner(System.`in`)
    do {
        val velocity = scanner.nextInt()
        val time = scanner.nextInt()
        println("${2*time*velocity}")
    } while(scanner.hasNext())
}
