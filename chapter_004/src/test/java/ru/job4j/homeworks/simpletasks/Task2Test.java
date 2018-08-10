package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task2Test {
    Task2 test = new Task2(0, 1);
    Task2 point = new Task2(0, 3);
    Task2 point2 = new Task2(4, 0);

    @Test
    public void whenTryToFindDistationBetweenTwoPointsThenDoIt() {
        assertThat(test.pointDistanceTo(point), is(2.0));
        assertThat(point.pointDistanceTo(point2), is(5.0));
    }
}
