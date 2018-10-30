package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12135Test {
    Task12135 test = new Task12135();
    int[][] array = {{1, 2, 3}, {3, 2, 1}, {1, 3, 4, 5}};

    @Test
    public void whenTryToFindNumberIntoLineThenDoIt() {
        assertThat(1, is(test.findColumn(array, 2, 3)));
        assertThat(-1, is(test.findColumn(array, 1, 4)));
    }
}
