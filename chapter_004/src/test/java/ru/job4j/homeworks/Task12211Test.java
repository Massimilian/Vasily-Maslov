package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12211Test {
    private Task12211 test = new Task12211();
    private int[][] array = {{1, 0, 2, 3, 2, 0, -1, -2}, {5, 0, 5}, {}, {0, 0, 0, 1, 1, 1, -1, -2, -3}};
    private int[][] resultArray = {{1, -2, 2, 3, 2, 0, -1, 0}, {5, 0, 5}, {}, {-3, 0, 0, 1, 1, 1, -1, -2, 0}};
    private int[][] inmutableArray = {{2, 3, 4, 5}, {0, 1, 2, 3}};

    @Test
    public void whenTryToChangeArrayThenDoIt() {
        assertThat(test.changeZeroAndSubzero(array), is(resultArray));
        assertThat(test.changeZeroAndSubzero(inmutableArray), is(inmutableArray));
    }
}
