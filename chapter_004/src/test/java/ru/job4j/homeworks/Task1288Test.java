package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1288Test {
    Task1288 test = new Task1288();
    int[][] array = {{1, 2, 3}, {3, 4, 2, -1}, {0, -1, 1, 2, 4}};

    @Test
    public void whenTryToFindANumberOfColumnWithMaxValueThenReturnIt() {
        assertThat(1, is(test.findColumn(array)));
    }

    @Test
    public void whenTryToFindNumberOfLineWithMinValueThenReturnIt() {
        assertThat(2, is(test.findString(array)));
    }
}
