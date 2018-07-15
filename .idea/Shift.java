package domain;

public class Shift {
    private String time;
    private int numSlots;

    public Shift() {

    }

    public Shift(String time, int numSlots) {
        this.time = time;
        this.numSlots = numSlots;
    }

    public String getTime() {
        return this.time;
    }

    public int getNumSlots() {
        return this.numSlots;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setNumSlots(int numSlots) {
        this.numSlots = numSlots;
    }

    @Override
    public String toString() {
        return "Shift at time " + this.time + " with " + this.numSlots + " number of slots";
    }
}