package studyroom.cleaning;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

public class CleaningTask {
    private final String description;
    private final LocalTime scheduledTime;
    private final Set<DayOfWeek> applicableDays;
    private boolean completed;

    public CleaningTask(String description, LocalTime scheduledTime, Set<DayOfWeek> applicableDays) {
        this.description = description;
        this.scheduledTime = scheduledTime;
        this.applicableDays = Set.copyOf(applicableDays);
    }

    public boolean isScheduledOn(DayOfWeek day) {
        return applicableDays.contains(day);
    }

    public void complete() {
        completed = true;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getScheduledTime() {
        return scheduledTime;
    }

    public boolean isCompleted() {
        return completed;
    }
}
