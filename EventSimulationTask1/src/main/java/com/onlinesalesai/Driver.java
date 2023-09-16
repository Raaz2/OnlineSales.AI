package com.onlinesalesai;

import java.util.HashMap;

public class Driver {
    public static void main(String[] args) {
        //Define the biased event outcomes and probabilities
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Head",35); // head, 35% of 1000 = 350
        hm.put("Tail",65); // tail, 65% of 1000 = 650

        Simulation<String> event = new Simulation<>(hm);

        int n = 1000; //simulate the even 1000 times;
        int headCount = 0;
        int tailCount = 0;

        for (int i = 1; i <= n; i++) {
            String result = event.simulate();
            if (result != null) {
                if (result.equals("Head")) {
                    headCount++;
                } else if (result.equals("Tail")) {
                    tailCount++;
                }
            }
        }

        //Displaying the results
        System.out.println("Event triggered: " + n + " times.");
        System.out.println("Head appeared: " + headCount + " times.");
        System.out.println("Tail appeared: " + tailCount + " times.");

    }
}
