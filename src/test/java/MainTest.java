import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.example.Main;
public class MainTest {
    @Test
    void addition() {
        assertEquals(233168, Main.problem1(0, 1000));
        assertEquals(4613732, Main.problem2(1, 2, 4000000));
    }
}
