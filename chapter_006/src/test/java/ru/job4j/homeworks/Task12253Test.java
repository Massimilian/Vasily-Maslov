package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12253Test {
    private int[][] array = {{0, 1, 2}, {1, 2, 3}, {2, 3, 4}};
    private int from = 3;
    private int to = 2;
    private int toTwo = 1;
    private int[][] stringResult = {{2, 3, 4}, {0, 1, 2}, {1, 2, 3}};
    private int[][] columnResult = {{2, 0, 1}, {3, 1, 2}, {4, 2, 3}};
    private int[][] specialStringResult = {{0, 1, 2}, {2, 3, 4}, {1, 2, 3}};
    private int[][] specialStringResultTwo = {{1, 2, 3}, {0, 1, 2}, {2, 3, 4}};
    private int[][] specialColumnResult = {{0, 2, 1}, {1, 3, 2}, {2, 4, 3}};
    private int[][] specialColumnResultTwo = {{2, 0, 1}, {3, 1, 2}, {4, 2, 3}};
    private Task12253 test = new Task12253();

    @Test
    public void whenTryToChangeStringThenDoIt() {
        assertThat(test.changeString(array), is(stringResult));
    }

    @Test
    public void whenTryToChangeColumnThenDoIt() {
        assertThat(test.changeColumn(array), is(columnResult));
    }

    @Test
    public void whenTryToChangeConcreteStringThenDoIt() {
        assertThat(test.specialChangeString(array, to, from), is(specialStringResult));
        assertThat(test.specialChangeString(specialStringResult, toTwo, from), is(specialStringResultTwo));
    }

    @Test
    public void whenTryToChangeConcreteColumnThenDoIt() {
        assertThat(test.specialChangeColumn(array, to, from), is(specialColumnResult));
        assertThat(test.specialChangeColumn(array, toTwo, from), is(specialColumnResultTwo));
    }
}
