# Event Simulation with Biasness

This program simulates events with specified biasness. You can use it to simulate various events, like rolling a biased dice or flipping a biased coin.

## How to Run

1. Clone or download the repository to your local machine.

2. Open the project in your preferred Java development environment.

3. Run the `Driver.java` class for the coin flip simulation or the `DiceDriver.java` class for the dice roll simulation.

4. Observe the results in the console.

## Code Structure

- The `Simulation` class is responsible for simulating events with biasness.
- `Driver.java` and `DiceDriver.java` demonstrate how to use the `Simulation` class for simulating coin flips and dice rolls.
- `SimulationTest.java` contains unit tests for the `Simulation` class.

## Assumptions

- The probabilities are provided as integers that represent percentages.
- The sum of all probabilities for an event equals 100%.
- The random number generator generates a number between 1 and 100 (inclusive) to match the provided probabilities.
- For the dice simulation, it is assumed that a 0% probability implies that a specific outcome will never occur.

## Unit Tests

- The `SimulationTest.java` class includes unit tests to ensure the correctness of the simulation and the total probability calculation.