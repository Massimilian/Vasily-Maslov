package ru.job4j.homeworks.switcher;

public class StringObjectWorker implements Runnable {
    private StringObject so = new StringObject();
    private String name;
    private int count;

    public StringObjectWorker(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.printf("%s: %s %d%s.", this.name, so.getS(), i + 1, System.lineSeparator());
        }
    }
}