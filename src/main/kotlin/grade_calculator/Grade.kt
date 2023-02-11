package grade_calculator

/**
 * A class for storing information about a grade cut-off
 *
 * @property a The grade cutoff for an A
 * @property aMinus The grade cutoff for an A-
 * @property bPlus The grade cutoff for a B+
 * @author Lukas Waschuk
 */
data class Grade(val a: Double, val aMinus: Double, val bPlus:Double)
