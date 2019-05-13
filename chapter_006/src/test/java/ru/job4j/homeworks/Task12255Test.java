package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12255Test {
    private Task12255 test = new Task12255();
    private int[][] array = {{4, 5, 6, 0, 1, 2, 3}, {4, 5, 6, 0, 1, 2, 3}, {4, 5, 6, 0, 1, 2, 3}, {4, 5, 6, 0, 1, 2, 3}};
    private int count = 3;
    private int[][] result = {{0, 1, 2, 3, 4, 5, 6}, {0, 1, 2, 3, 4, 5, 6}, {0, 1, 2, 3, 4, 5, 6}, {0, 1, 2, 3, 4, 5, 6}};
    private int anotherCount = 5;
    private int[][] anotherResult = {{5, 6, 0, 1, 2, 3, 4}, {5, 6, 0, 1, 2, 3, 4}, {5, 6, 0, 1, 2, 3, 4}, {5, 6, 0, 1, 2, 3, 4}};

    @Test
    public void whenTryToChangeColumnsInArrayThenDoIt() {
        assertThat(test.changeColumns(array, count), is(result));
        assertThat(test.changeColumns(result, anotherCount), is(anotherResult));
    }

}
