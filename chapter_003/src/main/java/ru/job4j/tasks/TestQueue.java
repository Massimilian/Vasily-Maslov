package ru.job4j.tasks;

public class TestQueue {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.put(new Task(1, "Very hot"));
        pq.put(new Task(0, "Very-very hot"));
        pq.put(new Task(1, "Very hot"));
        pq.put(new Task(1, "Very hot"));
        pq.put(new Task(0, "Very-very hot"));
        pq.put(new Task(0, "Very-very hot"));

    }
}
