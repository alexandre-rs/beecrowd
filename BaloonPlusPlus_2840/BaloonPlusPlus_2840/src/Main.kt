
import java.util.Scanner

val PI = 3.1415

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val radio: Int = sc.nextInt()
    val L: Int = sc.nextInt()
    val V = (4.0/3.0)*PI*radio*radio*radio
    val result = L / V
    println("${result.toInt()}")
}

