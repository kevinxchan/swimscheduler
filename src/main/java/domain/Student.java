package domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.ArrayList;
import java.util.List;

@PlanningEntity
public class Student {
    private List<String> timesAvailable;
    private List<String> timesUnavailable;
    private int genderPreference; // 0 = male, 1 = female, 2 = no preference
    private String name;
    private Shift assignedShift; // planning var

    public Student() {

    }

    public Student(List<String> timesAvailable, List<String> timesUnavailable, int genderPreference, String name) {
        this.timesAvailable = new ArrayList<String>(timesAvailable);
        this.timesUnavailable = new ArrayList<String>(timesUnavailable);
        setGenderPreference(genderPreference);
        this.name = name;
    }

    public List<String> getTimesAvailable() {
        return timesAvailable;
    }

    public List<String> getTimesUnavailable() {
        return timesUnavailable;
    }

    public int getGenderPreference() {
        return genderPreference;
    }

    public String getName() {
        return name;
    }

    @PlanningVariable(valueRangeProviderRefs = {"shiftStudentRange"})
    public Shift getAssignedShift() {
        return assignedShift;
    }

    public void setTimesAvailable(List<String> timesAvailable) {
        this.timesAvailable = timesAvailable;
    }

    public void setTimesUnavailable(List<String> timesUnavailable) {
        this.timesUnavailable = timesUnavailable;
    }

    public void setGenderPreference(int genderPreference) {
        if (genderPreference >= 0 && genderPreference <= 2)
            this.genderPreference = genderPreference;
        else
            throw new IllegalArgumentException("Gender preference must be between 0 and 2");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAssignedShift(Shift assignedShift) {
        this.assignedShift = assignedShift;
    }

    @Override
    public String toString() {
        return "Student name: " + name + "\n" +
                "Student times available: " + timesAvailable.toString() + "\n" +
                "Student times unavailable: " + timesUnavailable.toString() + "\n" +
                "Student gender preference: " + genderPreference + "\n" +
                "Student assigned shift: " + assignedShift.toString();
    }
}
