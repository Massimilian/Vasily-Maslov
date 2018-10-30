package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12179Test {
    Task12179 test = new Task12179();
    int[][] array = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};

    @Test
    public void whenTryToFillArrayThenDoIt() {
        assertThat(test.fillArray(array, 1), is(new int[][]{{0, 1, 2, 3, 4}, {1, 0, 1, 2, 3}, {2, 1, 0, 1, 2}, {3, 2, 1, 0, 1}, {4, 3, 2, 1, 0}}));
    }

    @Test
    public void whenTryToFillArrayFromAnotherSideThenDoIt() {
        assertThat(test.fillArrayWithAnotherWay(array, 1), is(new int[][]{{4, 3, 2, 1, 0}, {3, 2, 1, 0, 1}, {2, 1, 0, 1, 2}, {1, 0, 1, 2, 3}, {0, 1, 2, 3, 4}}));
    }
}
