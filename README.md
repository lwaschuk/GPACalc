# GPACalculator

GPACalculator is a Kotlin program that calculates your current grade in a course based on the grades you have received so
far and the percentage of the course that has been completed. It can also tell you what grade you need to receive 
on the remaining assignments in order to achieve a desired grade.

## Releases
[![Release](https://img.shields.io/github/release/Napkinzz/GPACalc.svg?style=for-the-badge)](https://github.com/Napkinzz/GPACalc/releases)

[![Software License](https://img.shields.io/badge/license-MIT-brightgreen.svg?style=for-the-badge)](LICENSE.md)

## Usage  
To use GPACalculator, you need to pass it the grade cutoffs for A, A-, and B+ grades, followed by the grades and weight
of the assignments you have completed so far. For example:

```bash
./gradlew run --args='<A grade cutoff> <A- grade cutoff> <B+ grade cutoff> <grade1> <percentage1> <grade2> <percentage2> ... <gradeN> <percentageN>'
```

This will execute the program with the A, A-, and B+ grade cutoffs set at 90%, 85%, and 80%, respectively. You have 
already completed three assignments, scoring 90% on an assignment worth 20% of the course, 91% on an assignment worth 
15% of the course, and 80% on an assignment worth 45% of the course.  

GPACalculator will calculate your current grade based on the completed assignments and tell you what grade you need to 
receive on the remaining assignments in order to achieve an A, A-, or B+ grade.

## Building and Running with Gradle

To build and run GPACalculator, you need to have Gradle installed. Simply run the following command in your terminal:

```bash
./gradlew run --args='90 85 80 90 20 91 15 80 45'
```

This will compile the code, build the application, and run it with the arguments you provided.

## Building a JAR and Running the Application with Java

If you want to build a JAR file of GPACalculator and run it on the command line, you can use Gradle to do this.

To build the JAR file, run the following command in your terminal:

```bash
./gradlew fatJar
```

This will create a JAR file in the build/libs directory. The file will be named GPACalculator.jar

To run the JAR file, use the following command:

```bash
java -jar build/libs/GPACalculator.jar 90 85 80 90 20 91 15 80 45 
```

Replace `90 85 80 90 20 91 15 80 45` with the arguments you want to pass to the program.  

> Usage:
> `<A grade cutoff> <A- grade cutoff> <B+ grade cutoff> <grade1> <percentage1> <grade2> <percentage2> ... <gradeN> <percentageN>`

The JAR file contains all the necessary dependencies, so you can run it on any machine that has Java installed, without 
having to install Gradle or any other dependencies.

## Running the Application from a JAR downloaded from Releases

You can also download the JAR file from the [releases page][releases] section on GitHub, and run it locally on any machine that has 
Java installed.

[releases]:  https://github.com/Napkinzz/GPACalc/releases

To run the JAR file, use the following command in your terminal:

```bash
java -jar GPACalculator.jar 90 85 80 90 20 91 15 80 45 
```

Replace `90 85 80 90 20 91 15 80 45`  with the arguments you want to pass to the program.

The JAR file contains all the necessary dependencies, so you can run it on any machine that has Java installed, without 
having to install Gradle or any other dependencies.


## Example Execution
### Input  

```bash
java -jar build/libs/GPACalculator.jar 90 85 80 90 20 91 15 80 45 
```

### Output 
``` 
Ingested:
	Grade 90.0 worth 20.0 percent
	Grade 91.0 worth 15.0 percent
	Grade 80.0 worth 45.0 percent

You need 111.90% on the remaining 20.0% of the course to finish with a A (90.0%)
You need 86.90% on the remaining 20.0% of the course to finish with a A- (85.0%)
You need 61.90% on the remaining 20.0% of the course to finish with a B+ (80.0%)

	** You have 84.56% over 80.0% of the course completed **
```
