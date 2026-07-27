import java.util.*

const val cutoffScore = 8f

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`).useLocale(Locale.US)
    var n = scanner.nextInt()
    var maxGrade: Float = 0f
    var studentIdHighestGrade = -1;
    while (n > 0) {
        val studentId = scanner.nextInt()
        val grade = scanner.nextFloat()
        if (grade >= cutoffScore && grade > maxGrade) {
            maxGrade = grade
            studentIdHighestGrade = studentId
        }
        n--
    }
    if (maxGrade >= cutoffScore) {
        println(studentIdHighestGrade)
    } else {
        println("Minimum note not reached")
    }
    scanner.close()

}