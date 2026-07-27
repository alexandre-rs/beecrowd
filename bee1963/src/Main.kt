import java.util.Scanner

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val scanner = Scanner(System.`in`)
    val value_a: Float = scanner.nextFloat()
    val value_b: Float = scanner.nextFloat()
    val percentageIncrease: Float = (value_b - value_a)/value_a * 100f
    println("%.2f%%".format(percentageIncrease))
}