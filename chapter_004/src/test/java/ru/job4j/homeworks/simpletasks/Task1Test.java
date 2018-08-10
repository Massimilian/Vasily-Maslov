package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1Test {
    Task1 test = new Task1();
    int x = 5;
    int y = 10;

    @Test
    public void whenTryToUseMathOperationsThenWorksWell() {
        assertThat(test.sum(x, y), is(15.0));
        assertThat(test.subtraction(x, y), is(-5.0));
        assertThat(test.division(x, y), is(0.5));
        assertThat(test.multiplication(x, y), is(50.0));
        assertThat(test.pow(x, y), is(9765625.0));
    }
}
