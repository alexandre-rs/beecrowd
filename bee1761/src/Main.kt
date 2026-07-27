//https://resources.beecrowd.com/repository/UOJ_1761.html

import java.util.Scanner
import kotlin.math.tan

const val PI =3.141592654

fun Double.toRadians(): Double {
    return this * PI / 180.0
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    while(scanner.hasNext()) {
        val degree = scanner.nextDouble()
        val distance = scanner.nextDouble()
        val elfHeight = scanner.nextDouble()
        val radians = degree.toRadians()
        //tang x = cateto oposto / cateto adjascente -> cateto oposto = tang x * cateto adjascente
        val treeHeight = 5.0 * (elfHeight + tan(radians) * distance)
        println(String.format("%.2f", treeHeight))
    }
}