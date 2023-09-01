# App description

To run test for the application you simply need to execute

```bash
./mvnw clean verify
```

## `StudentConverterTest`

The purpose of this class is to test `convertStudents(List<Student>)` method that accepts a list of `Student` DTOs and returns
a new list of student DTOs with boolean marks:

* `exceptional` - for students under age of 21 with the grade above 90
* `honorRoll` - for students above age of 21 with the grade above 90
* `passed` - for students that have grades in range \[71, 90\] inclusive.
  The method does not mutate its argument.

The test class covers cases for 3 different marks. Also, it covers negative cases, when the parameter is `null` and empty list.

## `PlayerAnalyzerTest`

The purpose of this class is to test `calculateScore(List<Player>)` method that accepts a list of `Player` DTOs and returns their combined score.
The test class covers main scenarios for 3 kind of players (junior, normal, and senior) as well as the 3 players together.
Also, it covers negative cases, when the parameter is and empty list or a player contains `null` skills list.
