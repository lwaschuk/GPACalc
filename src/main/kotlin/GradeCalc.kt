class GradeCalc {
    fun getGrade(args: Array<String>) {
        var totalGrade = 0.0
        var totalPercent = 0.0
        println("Ingested:")
        for (i in args) {
            val grades = i.split(":")
            println("\tGrade ${grades[0]} worth ${grades[1]} percent")
            totalPercent += grades[1].toInt()
            totalGrade += (grades[0].toInt() * grades[1].toInt() / 100)
        }
        println()
        if (totalPercent < 100) {
            gradesLeft(totalPercent, totalGrade)
        }
        totalGrade /= totalPercent / 100
        val stringTotalGrade = String.format("%.2f", totalGrade)
        println("\n\t** You have $stringTotalGrade% over $totalPercent% of the course completed **")
    }

    private fun gradesLeft(totalPercent: Double, totalGrade: Double) {
        val grade = Grade(90, 85, 80)

        val remainingPercentage = 100 - totalPercent
        var tempTotal = 0.0
        var needGrade = 1.0
        while (tempTotal < grade.A) {
            tempTotal = totalGrade
            val remainder = needGrade * remainingPercentage / 100
            tempTotal += remainder
            needGrade += 0.1
        }
        var stringNeedGrade = String.format("%.2f", needGrade)
        println("You need $stringNeedGrade% on the remaining $remainingPercentage% of the course to finish with a A (${grade.A}%)")

        tempTotal = 0.0
        needGrade = 1.0
        while (tempTotal < grade.A_MINUS) {
            tempTotal = totalGrade
            val remainder = needGrade * remainingPercentage / 100
            tempTotal += remainder
            needGrade += 0.1
        }
        stringNeedGrade = String.format("%.2f", needGrade)
        println("You need $stringNeedGrade% on the remaining $remainingPercentage% of the course to finish with a A- (${grade.A_MINUS}%)")

        tempTotal = 0.0
        needGrade = 1.0
        while (tempTotal < grade.B_PLUS) {
            tempTotal = totalGrade
            val remainder = needGrade * remainingPercentage / 100
            tempTotal += remainder
            needGrade += 0.1
        }
        stringNeedGrade = String.format("%.2f", needGrade)
        println("You need ${stringNeedGrade}% on the remaining $remainingPercentage% of the course to finish with a B+ (${grade.B_PLUS}%)")
    }
}