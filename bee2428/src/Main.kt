import java.util.Scanner

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val areas = Array<Int>(4) { 0 }
    val scanner = Scanner(System.`in`)
    areas[0] = scanner.nextInt()
    areas[1] = scanner.nextInt()
    areas[2] = scanner.nextInt()
    areas[3] = scanner.nextInt()
    areas.sort()
    println(if (areas[0] * areas[3] == areas[1] * areas[2]) "S" else "N")
}