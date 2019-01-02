package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12249Test {
    private Task12249 test = new Task12249();
    private int[][] stringArray = {{1, 2, -3}, {0, 0}, {-1, -2, 3}, {-1, -2, 3, 4}};
    private int[][] columnArray = {{1, 2, -3, -4}, {-1, -2, 3, 4}, {0, 10, 0, 10}};
    private int[][] stringResult = {{1, 2, -3}, {0, 0}, {0, 0}, {-1, -2, 3}, {0, 0, 0, 0}, {-1, -2, 3, 4}};
    private int[][] columnResult = {{1, 10, 2, -3, 10, -4}, {-1, 10, -2, 3, 10, 4}, {0, 10, 10, 0, 10, 10}};
    private int stringNumber = 0;
    private int columnNumber = 10;

    @Test
    public void whenTryToChangeArrayThenDoIt() {
        assertThat(test.enterStrings(stringArray, stringNumber), is(stringResult));
        assertThat(test.enterColumn(columnArray, columnNumber), is(columnResult));
    }
}
