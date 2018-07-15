package domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.ArrayList;
import java.util.List;

@PlanningEntity
public class Volunteer {
    private List<String> timesAvailable; // ["3:00 PM", "4:00 PM", ...]
    private List<String> timesUnavailable;
    private int gender; // 0 = male, 1 = female
    private String name; // first and last
    private Shift assignedShift; // planning var

    public Volunteer() {

    }

    public Volunteer(List<String> timesAvailable, List<String> timesUnavailable, int gender, String name) {
        this.timesAvailable = new ArrayList<String>(timesAvailable);
        this.timesUnavailable = new ArrayList<String>(timesUnavailable);
        setGender(gender);
        this.name = name;
    }

    public List getTimesAvailable() {
        return timesAvailable;
    }

    public List getTimesUnavailable() {
        return timesUnavailable;
    }

    public int getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    @PlanningVariable(valueRangeProviderRefs = {"shiftRange"})
    public Shift getAssignedShift() {
        return assignedShift;
    }

    public void setTimesAvailable(List<String> timesAvailable) {
        this.timesAvailable = timesAvailable;
    }

    public void addTimeAvailable(String timeAvailable) {
        timesAvailable.add(timeAvailable);
    }

    public void setTimesUnavailable(List<String> timesUnavailable) {
        this.timesUnavailable = timesUnavailable;
    }

    public void addTimeUnavailable(String timeUnavailable) {
        timesAvailable.add(timeUnavailable);
    }

    public void setGender(int gender) {
        if (gender >= 0 && gender <= 1)
            this.gender = gender;
        else
            throw new IllegalArgumentException("Gender must be 0 (male) or 1 (female)");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAssignedShift(Shift assignedShift) {
        this.assignedShift = assignedShift;
    }

    @Override
    public String toString() {
        return "Volunteer name: " + name + "\n" +
                "Volunteer times available: " + timesAvailable.toString() + "\n" +
                "Volunteer times unavailable: " + timesUnavailable.toString() + "\n" +
                "Volunteer gender: " + gender + "\n" +
                "Volunteer assigned shift: " + assignedShift.toString();
    }
}
