package src;

import java.time.LocalDateTime;

public class Timecard {
    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;

    public Timecard(LocalDateTime clockInTime, LocalDateTime clockOutTime) {
        this.clockInTime = clockInTime;
        this.clockOutTime = clockOutTime;
    }

    public LocalDateTime getClockInTime() {
        return clockInTime;
    }

    public LocalDateTime getClockOutTime() {
        return clockOutTime;
    }

    public void setClockOutTime(LocalDateTime clockOutTime) {
        this.clockOutTime = clockOutTime;
    }
}
