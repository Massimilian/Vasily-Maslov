package ru.job4j.nonblockingcash;

public class Base {
    private int id;
    private int version;

    public Base(int id) {
        this.id = id;
        this.version = 0;
    }

    public Base(int id, int version) {
        this.id = id;
        this.version = version;
    }

    public Base upgrade() {
        return new Base(this.id, this.version + 1);
    }
    public int getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
