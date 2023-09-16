import com.onlinesalesai.Simulation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimulationTest {
    private Simulation<String> simulation;

    @BeforeEach
    public void setUp() {
        HashMap<String, Integer> probabilities = new HashMap<>();
        probabilities.put("A", 50);
        probabilities.put("B", 30);
        probabilities.put("C", 20);
        simulation = new Simulation<>(probabilities);
    }

    @Test
    public void testSimulateOutcome() {
        int n = 1000;
        int countA = 0;
        int countB = 0;
        int countC = 0;

        for (int i = 1; i <= n; i++) {
            String result = simulation.simulate();
            if (result != null) {
            assertTrue(result.equals("A") || result.equals("B") || result.equals("C"));
                if (result.equals("A")) {
                    countA++;
                } else if (result.equals("B")) {
                    countB++;
                } else if (result.equals("C")) {
                    countC++;
                }
            }
        }

        assertTrue(countA > countB);
        assertTrue(countB > countC);
    }

    @Test
    public void testCalculateTotalProb() {
        HashMap<String, Integer> probabilities = new HashMap<>();
        probabilities.put("A", 50);
        probabilities.put("B", 30);
        probabilities.put("C", 20);

        int totalProbability = simulation.calculateTotalProb(probabilities);
        assertEquals(100, totalProbability);
    }

}
