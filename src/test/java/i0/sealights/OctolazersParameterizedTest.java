package i0.sealights;

import i0.sealights.octolazersJava.Helpers;
import i0.sealights.octolazersJava.LaserData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OctolazersParameterizedTest extends OctolazersBaseTest {
    @ParameterizedTest
    @CsvSource({"29, 13195", "6857, 600851475143"})
    void correctlyCalculateLargestPrime(LaserData expected, int entry, LaserData.Direction direction){
        var returnedValue = Helpers.Shoot(exampleGrid, entry, direction);
        LaserData valueReturned = new LaserData(returnedValue.a, returnedValue.b);
        assertEquals(expected, valueReturned);
    }
}
