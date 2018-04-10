package practice;

public class TimeTest {
    public static void main(String[] args) {
        Time t = new Time(12, 40, 50);
        System.out.println(t);
        t.setHour(t.getHour() + 1);
        System.out.println(t);
    }
}

class Time {
    private int hour;
    private int minute;
    private int second;

    Time(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23)
            return;
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute < 0 || 59 < minute) return;
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        if (second < 0 || 59 < second) return;
    }

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }
}
