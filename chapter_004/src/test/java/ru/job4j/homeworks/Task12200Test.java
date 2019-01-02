package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12200Test {
    private Task12200 test = new Task12200();
    private int[][] array = {{1, 1, 1}, {1, 1}, {1, 1, 1, 1}};
    private int[][] result = {{1, 1, -1}, {1, 1}, {-1, -1, 1, -1}};

    @Test
    public void whenTryToChangeNumbersByStringAndColumnThenDoIt() {
        assertThat(test.makeSubzero(array, 2, 2), is(result));
    }
}
