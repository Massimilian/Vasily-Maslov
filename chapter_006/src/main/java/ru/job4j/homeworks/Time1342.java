package ru.job4j.homeworks;

public class Time1342 {
    private byte hour;
    private byte minute;

    public Time1342(int hour, int minute) {
        this.hour = (byte) hour;
        this.minute = (byte) minute;
    }


    public byte getHour() {
        return hour;
    }

    public byte getMinute() {
        return minute;
    }
}
