package i0.sealights;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.Random;

public class EulerBaseTest {
    protected Euler eulerSolver = new Euler();
    protected static String[] RandomWordProvider(){
        return Euler.RandomWordGenerator(20);
    }
}
