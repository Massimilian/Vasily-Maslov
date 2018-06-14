package ru.job4j.tasks;

import java.util.LinkedList;
import java.util.List;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getPriority() <= tasks.get(i).getPriority()) {
                tasks.add(i, task);
                break;
            } else {
                tasks.add(task);
                break;
            }
        }
        if (tasks.isEmpty()) {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }

    public List returnAllTasks() {
        return this.tasks;
    }
}
