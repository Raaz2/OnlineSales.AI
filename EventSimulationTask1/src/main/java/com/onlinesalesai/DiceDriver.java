package com.onlinesalesai;

import java.util.HashMap;

public class DiceDriver {
    public static void main(String[] args) {
        HashMap<Integer, Integer> probabilities = new HashMap<>();

        probabilities.put(1, 10); // 10% of 1000 = 100
        probabilities.put(2, 30); // 30% of 1000 = 300
        probabilities.put(3, 15); // 15% of 1000 = 150
        probabilities.put(4, 15); // 15% of 1000 = 150
        probabilities.put(5, 30); // 30% of 1000 = 300
        probabilities.put(6, 0);  // 0

        Simulation<Integer> event = new Simulation<>(probabilities);

        int n = 1000; //simulate the even 1000 times;
        int oneCount = 0, twoCount = 0, threeCount = 0, fourCount = 0, fiveCount = 0, sixCount = 0;

        for (int i = 1; i <= n; i++) {
            Integer result = event.simulate();
            if (result != null) {
                switch (result) {
                    case 1:
                        oneCount++;
                        break;
                    case 2:
                        twoCount++;
                        break;
                    case 3:
                        threeCount++;
                        break;
                    case 4:
                        fourCount++;
                        break;
                    case 5:
                        fiveCount++;
                        break;
                    case 6:
                        sixCount++;
                        break;
                    default:
                        break;
                }
            }

        }

        //Displaying the results
        System.out.println("Event triggered: " + n + " times.");
        System.out.println("1 appeared: " + oneCount + " times.");
        System.out.println("2 appeared: " + twoCount + " times.");
        System.out.println("3 appeared: " + threeCount + " times.");
        System.out.println("4 appeared: " + fourCount + " times.");
        System.out.println("5 appeared: " + fiveCount + " times.");
        System.out.println("6 appeared: " + sixCount + " times.");
    }
}
