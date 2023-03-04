#!/bin/bash

# Example usage of the GPA Calculator to monitor the term GPA of a student
# Expected usage:
# java ... <A grade cutoff> <A- grade cutoff> <B+ grade cutoff> <grade1> <percentage1> <grade2> <percentage2> ... <gradeN> <percentageN>
# Remember to update the path to the GPACalculator.jar
echo "*** WINTER 2023 ***"
echo "CMPUT 279 (Completed):"
java -jar ~/git/Executables/GPACalculator.jar 90 85 80 80 10 20 5 80 30 90 55
echo ""

echo "CMPUT 229:"
java -jar ~/git/Executables/GPACalculator.jar 95 90 85 85 60 20 5 60 30
echo ""

echo "CMPUT 379 (Completed):"
java -jar ~/git/Executables/GPACalculator.jar 90 85 80 80 20 5 70 30 5 10 5
echo ""

echo "CMPUT 402:"
java -jar ~/git/Executables/GPACalculator.jar 90 85 80 80 10 20 5 90 30
echo ""
