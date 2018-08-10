package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class Task5Test {
    Task2 pointX = new Task2(-1, 0);
    Task2 pointY = new Task2(-0.5, Math.sqrt(3) / 2);
    Task2 pointZ = new Task2(0, 0);
    Task5 test;

    @Test
    public void whenTryToCheckTriangleWhenItHasEqualsSizesThenReturnTrue() {
        // возможно ли написать тест при работе с иррациональными числами?
    }
}
