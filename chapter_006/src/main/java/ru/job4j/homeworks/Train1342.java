package ru.job4j.homeworks;

public class Train1342 {
    private int number;
    private Time1342 start;
    private Time1342 end;

    public Train1342(int number, Time1342 start, Time1342 end) {
        this.number = number;
        this.start = start;
        this.end = end;
    }

    public int getNumber() {
        return number;
    }

    public Time1342 getStart() {
        return start;
    }

    public Time1342 getEnd() {
        return end;
    }
}
