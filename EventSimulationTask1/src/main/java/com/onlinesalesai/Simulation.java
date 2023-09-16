package com.onlinesalesai;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Simulation<T> {
    private final HashMap<T, Integer> outcomes;
    private final Random random = new Random();

    public Simulation(HashMap<T, Integer> outcomes) {
        this.outcomes = outcomes;
    }

    public T simulate() {
        int totalProbability = calculateTotalProb(outcomes);
        int randomNumber = random.nextInt(totalProbability) + 1; // randomNumber will always be from 1 to 100 (inclusive)

        int tempProbability = 0;

        for (Map.Entry<T, Integer> map : outcomes.entrySet()) {
            tempProbability += map.getValue();
            if (randomNumber < tempProbability) {
                return map.getKey();
            }
        }

        return null;
    }

    public int calculateTotalProb(HashMap<T, Integer> probabilities) {
        return probabilities.values().stream().mapToInt(Integer::intValue).sum();
    }
}