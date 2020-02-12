enum displayMode {
    CLOCK, SECONDS;
}

enum radioStation {
    NONE, PURPLE_LOVE, YOUNGSTER, BONE;
}

class Clock {
    protected long seconds;
    private displayMode mode;

    public Clock(long seconds) {
        this.seconds = seconds;
        this.mode = displayMode.CLOCK;
    }

    public Clock(long seconds, displayMode mode) {
        this(seconds);
        this.mode = mode;
    }

    public void tick() {
        this.seconds++;
    }

    public String toString() {
        if (mode == displayMode.CLOCK) {
            long hour = seconds / 60 / 60;
            long minute = seconds / 60 % 60;
            long second = seconds % 60;
            String hourstr = hour < 10 ? "0" + hour : Long.toString(hour);
            String minstr = minute < 10 ? "0" + minute : Long.toString(minute);
            String secstr = second < 10 ? "0" + second : Long.toString(second);
            return hourstr + ":" + minstr + ":" + secstr;
        } else {
            return Long.toString(seconds);
        }
    }
}

class AlarmClock extends Clock {
    private long alarm;

    public AlarmClock(long seconds, long alarm) {
        super(seconds);
        this.alarm = alarm;
    }

    public AlarmClock(long hour, long minute, long second, long h, long m, long s) {
        super(second + 60 * minute + 3600 * hour);
        this.alarm = s + 60 * m + 3600 * h;
    }

    public boolean isGoingOff() {
        return seconds - alarm >=0 && seconds - alarm < 30;
    }

    public String toString() {
        if (this.isGoingOff()) {
            return super.toString() + " BEEP!";
        } else {
            return super.toString() + "";
        }
    }
}

class RadioAlarmClock extends AlarmClock {
    radioStation station;

    public RadioAlarmClock(long seconds, long alarm, radioStation station) {
        super(seconds, alarm);
        this.station = station;
    }

    public String toString() {
        return station == radioStation.NONE ? super.toString() : super.toString() + "blah, blah";
    }
    
}

public class Practicedd4c {
    public static void main(String[] args) throws InterruptedException {
        AlarmClock clock = new AlarmClock(86390, 86400);
        while (true) {
            System.out.println(clock);
            clock.tick();
            Thread.sleep(1000);
        }
    }
}