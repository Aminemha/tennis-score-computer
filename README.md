# Tennis Score Computer

The `TennisScoreComputerService` class represents a service that computes the score of a tennis game between two players. It keeps track of the players' scores and determines the winner of the game.

## Table of Contents

- [Introduction](#introduction)
- [Usage](#usage)
- [Testing](#testing)

## Introduction

In a tennis game, the score is represented using a combination of points: "0," "15," "30," "40," and "A" (advantage). The `TennisScoreComputerService` class takes a string representation of the game steps as input and computes the score based on those steps. It keeps track of the scores of two players, Player A and Player B, and determines the winner of the game.

## Usage

To use the `TennisScoreComputerService` class, follow these steps:

1. Create an instance of the `TennisScoreComputerService` class by providing the game steps as a string parameter.
2. Call the `computeScore()` method to compute the score of the tennis game.
3. The method will return the player object representing the winner of the game.

Here's an example of how to use the `TennisScoreComputerService` class:

```java
String game = "ABABAA";
TennisScoreComputerService scoreComputer = new TennisScoreComputerService(game);
Player winner = scoreComputer.computeScore();
System.out.println("The winner is Player " + winner.getName());
```

## Testing

The `TennisScoreComputerService` class includes a set of unit tests to ensure its functionality. The tests cover different game scenarios and expected outcomes. To run the tests, you can execute the `TennisScoreComputerServiceTest` class.

The tests validate the following:

- Multiple games with different game steps.
- Handling unfinished games.
- Handling invalid game steps.

You can find the test methods in the `TennisScoreComputerServiceTest` class.

Please note that the tests use the JUnit 5 framework for assertions and parameterized tests.

```java
@RunWith(JUnitPlatform.class)
class TennisScoreComputerServiceTest {
  // Test methods...
}
```