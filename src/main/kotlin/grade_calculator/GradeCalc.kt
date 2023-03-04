package grade_calculator

/**
 * Class for calculating the total grade and minimum grades needed to obtain a desired grade
 * based on the grade cutoffs and completed grades provided.
 *
 * @author Lukas Waschuk
 */
class GradeCalc {
    /**
     * Calculates the total grade and minimum grades needed to obtain a desired grade
     * based on the grade cutoffs and completed grades provided.
     *
     * @param args Array of command line arguments in the format:
     *             <A grade cutoff> <A- grade cutoff> <B+ grade cutoff>
     *             <grade1> <percentage1> <grade2> <percentage2> ...
     *             <gradeN> <percentageN>
     * @author Lukas Waschuk
     */
    fun getGrade( args: Array<String>) {
        val gradeCutoff = Grade(args[0].toDouble(), args[1].toDouble(), args[2].toDouble())
        var totalGrade = 0.0
        var totalPercent = 0.0

        // Calculate the total grade and total percentage
        for (i in 3 until args.size step 2) {
            val assignmentGrade = args[i].toDouble()
            val percent = args[i + 1].toDouble()
            totalPercent += percent
            totalGrade += (assignmentGrade * percent / 100)
        }
        // Calculate the total grade as a percentage
        totalGrade /= totalPercent / 100
        val stringTotalGrade = String.format("%.2f", totalGrade)

        // If the total percentage is less than 100, calculate the minimum grades needed
        if (totalPercent < 100) {
            gradesLeft(totalPercent, totalGrade, gradeCutoff)
            println("** Current Grade: $stringTotalGrade%, Completed: $totalPercent% **")
        }

        // if the percent is 100 print the letter grade obtained
        else {
            println("** Final Grade: $stringTotalGrade%, Completed: $totalPercent% **")
            println("Letter Grade: ${letterGrade(totalGrade, gradeCutoff)}")
        }
    }

    /**
     * Calculates the letter grade based on the total grade and grade cutoffs.
     *
     * @param totalGrade The total grade obtained so far
     * @param gradeCutoff The grade cutoffs for an A, A-, and B+
     * @return The letter grade obtained
     * @author Lukas Waschuk
     */
    private fun letterGrade(totalGrade: Double, gradeCutoff: Grade): String {
        return when {
            totalGrade >= gradeCutoff.a -> "A"
            totalGrade >= gradeCutoff.aMinus -> "A-"
            totalGrade >= gradeCutoff.bPlus -> "B+"
            else -> "F"
        }
    }


    /*
     * Prints the minimum grade needed on the remaining percentage of the course
     * to finish with an A, A-, or B+.
     *
     * @param totalPercent The total percentage of the course completed so far
     * @param totalGrade The total grade obtained so far
     * @param grade The grade cutoffs for an A, A-, and B+
     * @author Lukas Waschuk
     */
    private fun gradesLeft(totalPercent: Double, totalGrade: Double, grade: Grade) {
        val remainingPercentage = 100 - totalPercent
        val grades = listOf(grade.a, grade.aMinus, grade.bPlus)
        val gradeNames = listOf("A", "A-", "B+")
        grades.forEachIndexed { _, requiredGrade ->
            val needGrade = calculateNeededGrade(totalGrade, remainingPercentage, requiredGrade)
            val stringNeedGrade = String.format("%.2f", needGrade)
            println("Need $stringNeedGrade% on remaining $remainingPercentage% to get a $gradeNames[index] (${requiredGrade}%)")
        }
    }

    /**
     * Calculates the minimum grade needed on the remaining percentage of the course
     * to finish with the required grade.
     *
     * @param totalGrade The total grade obtained so far
     * @param remainingPercentage The remaining percentage of the course
     * @param requiredGrade The required grade cutoff
     * @return The minimum grade needed on the remaining percentage of the course
     * @author Lukas Waschuk
     */
    private fun calculateNeededGrade(totalGrade: Double, remainingPercentage: Double, requiredGrade: Double): Double {
        var tempTotal = 0.0
        var needGrade = 1.0
        while (tempTotal < requiredGrade) {
            tempTotal = totalGrade
            val remainder = needGrade * remainingPercentage / 100
            tempTotal += remainder
            needGrade += 0.1
        }
        return needGrade
    }
}