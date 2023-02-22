package i0.sealights;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EulerTest {
    private Euler eulerSolver = new Euler();
    @Test
    void sendWrongInputAndFailMultiples() {
        assertEquals(233168, eulerSolver.sumMultiplesInRange(0, 1000));
    }
    @Test
    void setofail() {
        assertEquals(233168, eulerSolver.sumMultiplesInRange(0, 1000));
        assertEquals(4643732, eulerSolver.sumEvenFibonacciInRange(1, 2, 4_000_000));
    }
    @Test
    void p3(){
        assertEquals(6008, eulerSolver.largesPrimeFactor(600_851_475_143L));
    }
}
