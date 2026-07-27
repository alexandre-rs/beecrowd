import java.util.*

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val rams = Array(n) { 0L }
    var total = 0L
    var i = 0
    while(i < n) {
        rams[i] = scanner.nextLong()
        total += rams[i]
        i++
    }

    i = 0;
    var numberOfRams: Long
    val stolenStartsSet = HashSet<Int>()
    var stolenRams = 0
    while (true) {
        numberOfRams = rams[i]
        if (rams[i] > 0) {
            rams[i]--
            stolenRams++
            stolenStartsSet.add(i)
        }
        if (numberOfRams % 2L != 0L) {
            i += 1
        } else {
            i -= 1
        }
        if (i >= rams.size || i < 0) {
            break
        }
    }
    println("${stolenStartsSet.size} ${total - stolenRams}")

}