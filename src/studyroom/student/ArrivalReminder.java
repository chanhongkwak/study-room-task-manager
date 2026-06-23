package studyroom.student;

import java.time.LocalTime;

public class ArrivalReminder {

    private final Student student;
    private LocalTime nextReminderTime;

    public ArrivalReminder(Student student) {
        this.student = student;
        this.nextReminderTime = student.getExpectedArrivalTime().plusMinutes(15);
    }

    public Student getStudent() {
        return student;
    }

    public LocalTime getNextReminderTime() {
        return nextReminderTime;
    }

    public void scheduleNext() {
        nextReminderTime = nextReminderTime.plusHours(1);
    }

    public boolean isDue(LocalTime currentTime) {
        return !student.isAttended()
                && !currentTime.isBefore(nextReminderTime);
    }

}
