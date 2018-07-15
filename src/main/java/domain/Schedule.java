package domain;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@PlanningSolution
public class Schedule {
    private List<Shift> shiftList;
    private List<Student> studentList;
    private List<Volunteer> volunteerList;
    private HardSoftScore score;

    public Schedule() {

    }

    public Schedule(List<Shift> shiftList, List<Student> studentList, List<Volunteer> volunteerList) {
        this.shiftList = shiftList;
        this.studentList = studentList;
        this.volunteerList = volunteerList;
    }

    @PlanningEntityCollectionProperty
    public List<Student> getStudentList() {
        return studentList;
    }

    @PlanningEntityCollectionProperty
    public List<Volunteer> getVolunteerList() {
        return volunteerList;
    }

    @ValueRangeProvider(id = "shiftRange")
    @ProblemFactCollectionProperty
    public List<Shift> getShiftList() {
        return shiftList;
    }

    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }

    public void setShiftList(List<Shift> shiftList) {
        this.shiftList = shiftList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setVolunteerList(List<Volunteer> volunteerList) {
        this.volunteerList = volunteerList;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }
}
