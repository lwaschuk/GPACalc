package program

import grade_calculator.GradeCalc
import java.lang.NumberFormatException

/**
 * The Run class is responsible for performing the main logic of the program.
 *
 * @author Lukas Waschuk
 */
class Run {
    /**
     * Main function that takes in command line arguments for the grade cutoffs and completed grades,
     * creates an instance of the grade_calculator.GradeCalc class, and calculates the total grade and minimum grades
     * needed to obtain a desired grade based off the 3 cutoffs given.
     *
     * @param args Array of command line arguments in the format:
     *             <A grade cutoff> <A- grade cutoff> <B+ grade cutoff>
     *             <grade1> <percentage1> <grade2> <percentage2> ...
     *             <gradeN> <percentageN>
     * @author Lukas Waschuk
     */
    fun run(args: Array<String>) {
        if (args.size <= 4 || args.size % 2 == 0) {
            println("Error: Usage: <A grade cutoff> <A- grade cutoff> <B+ grade cutoff> <grade1> <percentage1> <grade2> <percentage2> ... <gradeN> <percentageN>")
            println("")
            return
        }
        val calc = GradeCalc()
        try {
            calc.getGrade(args)
        } catch (e: NumberFormatException) {
            println("Error: <A grade cutoff> <A- grade cutoff> <B+ grade cutoff> <grade1> <percentage1> <grade2> <percentage2> ... <gradeN> <percentageN>")
        }
    }

    companion object {
        /**
         * The main function serves as the entry point of the program.
         *
         * @param args an array of command line arguments passed to the program
         * @author Lukas Waschuk
         */
        @JvmStatic
        fun main(args: Array<String>) {
            val run = Run()
            run.run(args)
        }
    }
}



