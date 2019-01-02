package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12241Test {
    Task12241 test = new Task12241();
    private int[][] array = {{1, 1, 1}, {1, 1}, {1}};
    private int[][] result = {{1, 1, 1}, {0, 0, 0}, {1, 1}, {1}};
    private int[][] anotherResult = {{0, 1, 1, 1}, {0, 1, 1}, {0, 1}};
    private int pos = 0;
    private int num = 0;

    @Test
    public void whenTryToModifyTheStringThenDoIt() {
        assertThat(test.modifyString(array, pos, num), is(result));
    }

    @Test
    public void whenTryToModifyTheColumnThenDoIt() {
        assertThat(test.modifyColumn(array, pos, num), is(anotherResult));
    }
}
