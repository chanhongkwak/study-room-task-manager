package studyroom.temperature;

import java.time.LocalTime;

public class TemperatureCheck {

    private final LocalTime scheduledTime;
    private boolean checked;
    private Double measuredTemperature;

    public TemperatureCheck(LocalTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public void check() {
        checked = true;
    }

    public void record(double temperature) {
        measuredTemperature = temperature;
        checked = true;
    }

    public boolean isChecked() {
        return checked;
    }
}
