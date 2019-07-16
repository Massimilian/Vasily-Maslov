package ru.job4j.problems.starvation;

public class Resourse {
    private int i;

    public Resourse(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void dec() {
        this.i--;
    }
}
