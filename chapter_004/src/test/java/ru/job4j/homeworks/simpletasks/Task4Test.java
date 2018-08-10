package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task4Test {
    Task2 pointX = new Task2(0, 0);
    Task2 pointY = new Task2(2, 0);
    Task2 pointZ = new Task2(0, 2);
    Task2 wrongPoint = new Task2(255, 255);
    Task4 test;

    @Test
    public void whenTryToConstructTriangleWithToEqualSidesThenDoItOrNotIfImpossible() {
        test = new Task4(pointX, pointY, pointZ);
        assertThat(test.exist(), is(true));
        test = new Task4(pointX, pointY, wrongPoint);
        assertThat(test.exist(), is(false));
        test = new Task4(pointY, wrongPoint, pointZ);
        assertThat(test.exist(), is(true));
    }
}
