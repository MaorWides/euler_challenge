package i0.sealights;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EulerTest {
    private Euler eulerSolver = new Euler();
    @ParameterizedTest
    @CsvSource({"23,0,10", "2318,0,100", "233168,0,1000", "78,0,20", "9168,0,200", "931668,0,2000", "119,0,23", "12614,0,234", "1281153,0,2345"})
    void correctlyCalculateMultiplesInRange(long expectation, int min, int max) {
        assertEquals(expectation, eulerSolver.sumMultiplesInRange(min, max));
    }
    @ParameterizedTest
    @CsvSource({"10,1,2,10", "44,1,2,100", "4613732,1,2,4000000", "10,1,2,20", "188,1,2,200", "798,1,2,2000", "10,1,2,23", "188,1,2,234", "798,1,2,2345"})
    void correctlyCalculateFibonacciInRange(long expected, int first1, int first2, int max) {
        assertEquals(expected, eulerSolver.sumEvenFibonacciInRange(first1, first2, max));
    }
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
