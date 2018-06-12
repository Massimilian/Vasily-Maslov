package ru.job4j.tasks;

public class Task {
    private String desc;
    private int priority;

    public Task(int priority, String desc) {
        this.priority = priority;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
