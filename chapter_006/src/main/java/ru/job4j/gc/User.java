package ru.job4j.gc;

public class User {
    int count;

    public User(int count) {
        this.count = count;
        System.out.printf("Object %d made.%s", count, System.lineSeparator());
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("Object %d deleted.%s", count, System.lineSeparator());
    }
}
