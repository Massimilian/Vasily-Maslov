package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12252Test {
    Task12252 test = new Task12252();
    int[][] easyArray = {{1, 2}, {3, 4}};
    int[][] newEasyArray = {{1, 2}, {3, 4}};
    int to = 1;
    int from = 3;
    int[][] array = {{1, 2}, {3, 4, 5, 6}, {7, 8, 9}, {10}};
    int[][] stringResult = {{1, 2}, {10}, {3, 4, 5, 6}, {7, 8, 9}};
    int colFrom = 4;
    int[][] columnArray = {{0, 2, 3, 4, 1, 5}, {0, 2, 3, 4, 1, 5}};
    int[][] columnResult = {{0, 1, 2, 3, 4, 5}, {0, 1, 2, 3, 4, 5}};

    @Test
    public void whenMakeCircleTurnWithArraysAndColumnsThenreturnResult() {
        newEasyArray = test.circleRemoveArray(newEasyArray);
        newEasyArray = test.circleRemoveArray(newEasyArray);
        newEasyArray = test.circleRemoveColumn(newEasyArray);
        assertThat(test.circleRemoveColumn(newEasyArray), is(easyArray));
    }

    @Test
    public void whenTryToRemoveThisArrayThenDoIt() {
        assertThat(test.removeArrays(array, from, to), is(stringResult));
    }

    @Test
    public void whenTryToRemoveThisColumnsThenDoIt() {
        assertThat(test.removeColumn(columnArray, colFrom, to), is(columnResult));
    }
}
