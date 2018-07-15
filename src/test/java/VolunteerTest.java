import domain.Shift;
import domain.Volunteer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class VolunteerTest {
    private Volunteer v;
    private Shift s;

    private List<String> timesAvailable = new ArrayList<String>();
    private List<String> timesUnavailable = new ArrayList<String>();

    @Before
    public void runBefore() {
        timesAvailable.add("3:00 PM");
        timesUnavailable.add("4:00 PM");
        v = new Volunteer(timesAvailable, timesUnavailable, 0, "Foo Bar");
        s = new Shift("3:00 PM", 1);
    }

    @Test
    public void testConstructor() {
        v.setAssignedShift(s);
        String expected =
                "Volunteer name: Foo Bar" + "\n" +
                    "Volunteer times available: [3:00 PM]" + "\n" +
                    "Volunteer times unavailable: [4:00 PM]" + "\n" +
                    "Volunteer gender: 0" + "\n" +
                    "Volunteer assigned shift: Shift at time 3:00 PM with 1 number of slots";
        Assert.assertEquals(expected, v.toString());
    }
}
