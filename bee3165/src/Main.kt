import java.util.Scanner
import kotlin.math.sqrt

fun getPrimes(n: Int): ArrayList<Int> {
    val isPrime = BooleanArray(n + 1) { true }
    val rootSquare = sqrt(n.toDouble()).toInt()

    isPrime[0] = false
    isPrime[1] = false

    for (p in 2..rootSquare) {
        if (isPrime[p]) {
            for (i in (p * p)..n step p) {
                isPrime[i] = false
            }
        }
    }
    val primes = ArrayList<Int>()
    for (i in 2..n) {
        if (isPrime[i]) {
            primes.add(i)
        }
    }

    return primes
}

fun getClosestTwinPrimes(n: Int) {
    val isPrime = BooleanArray(n + 1) { true }
    val rootSquare = sqrt(n.toDouble()).toInt()
    isPrime[0] = false
    isPrime[1] = false
    for (p in 2..rootSquare) {
        if (isPrime[p]) {
            for (i in (p * p)..n step p) {
                isPrime[i] = false
            }
        }
    }
    for (i in n downTo 2) {
        if (isPrime[i] && isPrime[i - 2]) {
            println("${i - 2} $i")
            break;
        }
    }
}


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    getClosestTwinPrimes(n)
}