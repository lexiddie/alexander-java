package com.dlex;

import java.text.DecimalFormat;

public class Time {

    private int hour;
    private int minute;
    private int second;
    private String time;

    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
        this.time = "";
    }

    public int getHour() {
        return this.hour;
    }
    public int getMinute() {
        return this.minute;
    }
    public int getSecond() {
        return this.second;
    }
    public String getTime() {
        return this.time;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public void setSecond(int second) {
        this.second = second;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String to12HourFormat(int hour, int minute, int second) {
        String[] denote = {"AM", "PM"};
        if ((hour >= 0 && hour <= 23) && (minute >= 0 && minute <= 59) && (second >= 0 && second <= 59)) {
            setHour(hour);
            setMinute(minute);
            setSecond(second);
            int hours = getHour();
            if (hour < 12  && hour >= 1) {
                setTime(denote[0]);
            } else if (hour > 12 && hour <= 23) {
                hours -= 12;
                setTime(denote[1]);
            } else if (hour == 12) {
                setTime(denote[1]);
            } else {
                hours += 12;
                setTime(denote[0]);
            }
            DecimalFormat df = new DecimalFormat("00");
            return df.format(hours) + ":" + df.format(getMinute()) + ":" + df.format(getSecond()) + " " + getTime();
        } else {
            return "Invalid time!, please input properly!";
        }
    }
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("00");
        return df.format(getHour()) + ":" + df.format(getMinute()) + ":" + df.format(getSecond());
    }
}
