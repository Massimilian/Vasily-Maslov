package ru.job4j.problems.starvation;

public class Baggage {
    private int i;

    public Baggage(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void incr() {
        i++;
    }
}
