package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12212Test {
    private Task12212 test = new Task12212();
    private int[][] array = {{-1, 0}, {0, -1}, {3, 2, 1, -1, 0, -2}, {5, 0, 5, 0, -10, -4, 0, -6, 0, 0, 4}};
    private int[][] result = {{0, -1}, {-1, 0}, {3, 2, 1, 0, -1, -2}, {5, 0, 5, 0, 0, -4, 0, -6, 0, -10, 4}};
    private int[][] inmutableArray = {{1, 2, 3}, {0, 1, 2, 3}, {-3, -2, -1}};

    @Test
    public void whenTryToChangeArrayThenDoItIfPossible() {
        assertThat(test.changeSubzeroAndZero(array), is(result));
        assertThat(test.changeSubzeroAndZero(inmutableArray), is(inmutableArray));
    }
}