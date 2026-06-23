package studyroom.student;

import java.time.LocalTime;

public class Student {

    private final String name;
    private final LocalTime expectedArrivalTime;
    private boolean attended;

    public Student(String name, LocalTime expectedArrivalTime) {
        this.name = name;
        this.expectedArrivalTime = expectedArrivalTime;
    }

    public String getName() {
        return name;
    }

    public LocalTime getExpectedArrivalTime() {
        return expectedArrivalTime;
    }

    public boolean isAttended() {
        return attended;
    }

    public void attend() {
        attended = true;
    }

    public boolean needsArrivalCheck(LocalTime currentTime) {
        return !attended && !currentTime.isBefore(expectedArrivalTime.plusMinutes(15));
    }
}
