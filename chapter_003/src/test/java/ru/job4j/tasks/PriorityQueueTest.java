package ru.job4j.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PriorityQueueTest {
    PriorityQueue pq = new PriorityQueue();
    Task task = new Task(2, "Not so hot");
    Task task1 = new Task(1, "Very hot");
    Task task2 = new Task(4, "May sleep");
    Task task3 = new Task(3, "Cold");

    @Test
    public void whenAskToPutTheTaskIntoArrayThenDoIt() {
        pq.put(task1);
        pq.put(task2);
        assertThat(pq.returnAllTasks().get(0), is(task1));
    }

    @Test
    public void whenAskToPollTheMostPriorityTaskFromTasksThenReturnIt() {
        pq.put(task);
        pq.put(task1);
        pq.put(task2);
        pq.put(task3);
        assertThat(pq.take(), is(task1));
    }

}
