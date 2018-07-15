import domain.Shift;
import domain.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    private Student s;
    private Shift shift;
    private List<String> timesAvailable = new ArrayList<String>();
    private List<String> timesUnavailable = new ArrayList<String>();

    @Before
    public void runBefore() {
        timesAvailable.add("4:00 PM");
        timesUnavailable.add("5:00 PM");
        timesUnavailable.add("6:00 PM");
        s = new Student(timesAvailable, timesUnavailable, 2, "Bar Foo");
        shift = new Shift("4:00 PM", 2);
        s.setAssignedShift(shift);
    }

    @Test
    public void testConstructor() {
        String expected =
                "Student name: Bar Foo" + "\n" +
                    "Student times available: [4:00 PM]" + "\n" +
                    "Student times unavailable: [5:00 PM, 6:00 PM]" + "\n" +
                    "Student gender preference: 2" + "\n" +
                    "Student assigned shift: Shift at time 4:00 PM with 2 number of slots";
        Assert.assertEquals(expected, s.toString());
    }
}
