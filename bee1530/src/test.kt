import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    do {
        val line = scanner.nextLine()
        val positions = line.mapIndexedNotNull { index, ch -> if (ch == '?') index else null }
        println(positions)
    } while (scanner.hasNextLine())
    scanner.close()
}