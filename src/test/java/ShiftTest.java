import domain.Shift;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ShiftTest {
    Shift s;

    @Before
    public void runBefore() {
        s = new Shift("3:00 PM", 10);
    }

    @Test
    public void testString() {
        String expected = "Shift at time 3:00 PM with 10 number of slots";
        assertEquals(s.toString(), expected);
    }
}
