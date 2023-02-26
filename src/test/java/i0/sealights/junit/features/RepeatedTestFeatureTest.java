package i0.sealights.junit.features;

import static i0.sealights.TestExecutionNotifier.getNotifier;
import static org.junit.jupiter.api.Assertions.assertTrue;

import i0.sealights.TestExecutionNotifier;
import org.junit.jupiter.api.RepeatedTest;

// todo SLDEV-14458 THIS IS EXAMPLE TEMPLATE TEST CLASS
// it shows how to write the rest of classes that will use other annotations of the JUnit

public class RepeatedTestFeatureTest {

    private static final TestExecutionNotifier NOTIFIER = getNotifier(RepeatedTestFeatureTest.class);

    @RepeatedTest(4)
    public void test01() {
        NOTIFIER.notifyExecution("test01");
        assertTrue(true);
    }
}
