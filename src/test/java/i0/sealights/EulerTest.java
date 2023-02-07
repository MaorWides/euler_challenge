package i0.sealights;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class EulerTest {
    private Euler eulerSolver = new Euler();
    @Test
    void correctlyCalculateMultiplesInRange() {
        assertEquals(233168, eulerSolver.sumMultiplesInRange(0, 1000));
    }
    @Test
    void correctlyCalculateFibonacciInRange() {
        assertEquals(4613732, eulerSolver.sumEvenFibonacciInRange(1, 2, 4000000));
    }
    @Test
    void sendWrongInputAndFailMultiples() {
        assertEquals(233168, eulerSolver.sumMultiplesInRange(0, 1000));
    }
    @Test
    void setofail() {
        assertEquals(233168, eulerSolver.sumMultiplesInRange(0, 1000));
        assertEquals(4643732, eulerSolver.sumEvenFibonacciInRange(1, 2, 4000000));
    }
}
