package ru.job4j.archive.battery;

public class Battery {
    private int load;

    public int getLoad() {
        return load;
    }

    public void exchange(Battery another) {
        this.load = another.load <= 0 ? load : load + another.getLoad();
    }

}
