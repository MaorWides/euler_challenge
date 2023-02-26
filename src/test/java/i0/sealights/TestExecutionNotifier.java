package i0.sealights;

import java.util.Arrays;
import java.util.List;

public class TestExecutionNotifier {

    private final Class testClass;

    private TestExecutionNotifier(final Class testClass) {
        this.testClass = testClass;
    }

    public static TestExecutionNotifier getNotifier(final Class testClass) {
        return new TestExecutionNotifier(testClass);
    }

    public void notifyExecution(final String testName) {
        System.out.println("Test execution: " + testClass.getCanonicalName() + "." + testName);
    }

    public void notifyExecution(final String testName, String... params) {
        final List<String> paramsList = Arrays.asList(params);
        System.out.println("Test execution: " + testClass.getCanonicalName() + "."
            + testName
            + "with params: " + paramsList);
    }
}
