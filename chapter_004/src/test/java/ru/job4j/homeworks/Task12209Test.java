package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12209Test {
    private Task12209 test = new Task12209();
    private int[][] array = {{-1, 0, 1, 2}, {2, 4, 3, 0, 0}, {5, 60, 0, 0, 0}};
    private int[][] arrayAfterFirstChange = {{-1, 0, 1, 1}, {2, 3, 3, 0, 0}, {5, 59, 0, 0, 0}};
    private int[][] arrayAfterSecondChange = {{-1, -1, 1, 1}, {2, 3, 3, -1, 0}, {5, 59, -1, 0, 0}};

    @Test
    public void whenTryToChangeArrayThenDoIt() {
        assertThat(test.decremChange(array), is(arrayAfterFirstChange));
        assertThat(test.zeroChange(array), is(arrayAfterSecondChange));
    }
}
