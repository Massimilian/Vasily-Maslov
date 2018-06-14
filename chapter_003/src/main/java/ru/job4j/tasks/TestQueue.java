package ru.job4j.tasks;

public class TestQueue {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.put(new Task(4, "4"));
        pq.put(new Task(3, "3"));
        pq.put(new Task(5, "5"));
        pq.put(new Task(2, "2"));
        pq.put(new Task(6, "6"));
        pq.put(new Task(1, "1"));
    }
}
