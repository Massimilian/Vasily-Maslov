package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1223Test {
    Task1223 test = new Task1223(7);
    int[][] first = {{1, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 0, 1, 0}, {1, 0, 0, 0, 0, 0, 1}};
    int[][] second = {{1, 0, 0, 1, 0, 0, 1}, {0, 1, 0, 1, 0, 1, 0}, {0, 0, 1, 1, 1, 0, 0}, {1, 0, 0, 1, 0, 0, 1}, {0, 0, 1, 1, 1, 0, 0}, {0, 1, 0, 1, 0, 1, 0}, {1, 0, 0, 1, 0, 0, 1}};
    int[][] third = {{1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1}};

    @Test
    public void whenTryToPaintFirstVersionThenDoIt() {
        assertThat(test.firstPaint(0, 1), is(first));
    }

    @Test
    public void whenTryToPaintSecondVersionThenDoIt() {
        assertThat(test.secondPaint(0, 1), is(second));
    }

    @Test
    public void whenTryToPaintThirdVersionThenDoIt() {
        assertThat(test.thirdPaint(0, 1), is(third));
    }
}
