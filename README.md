# GPACalc
To use in a script to check my grades fast. Allows me to specify grade cutoffs and its main use in in a termal startup script to give me a quick rundown on my current grades in every class. 

## Usage 
`java -jar SNAPSHOT.jar <grade : weight> <grade : weight> <grade : weight> ...etc`

**__NOTE:__** You probably want to add to your .bashrc (or equivilant) so you can just update your grades in one place and don't have to re-enter them everytime. :shrug:


## Input 
`java -jar GPACalculator-1.0-SNAPSHOT-standalone.jar 90:10 90:20 60:30`
## Output 
``` 
Ingested:
        Grade 90 worth 10 percent
        Grade 90 worth 20 percent
        Grade 60 worth 30 percent

You need 112.70% on the remaining 40.0% of the course to finish with a A (90%)
You need 100.20% on the remaining 40.0% of the course to finish with a A- (85%)
You need 87.70% on the remaining 40.0% of the course to finish with a B+ (80%)

        ** You have 75.00% over 60.0% of the course completed *
```
