import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var n = scanner.nextInt()
    while(n!=0) {
        println("${n*(n+1)*(2*n+1)/6}")
        n = scanner.nextInt()
    }
}
