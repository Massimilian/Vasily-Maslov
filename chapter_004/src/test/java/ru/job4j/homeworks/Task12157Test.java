package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12157Test {
    Task12157 test = new Task12157();
    int[][] array = {{1, 6, 1}, {4, 2, 54}, {3, 23423, 3}};
    int[] result = {1, 2, 3};

    @Test
    public void whenTryToReturnDiagonalNumbersThenDoIt() {
        assertThat(test.rightResult(array), is(result));
        assertThat(test.leftDiagonal(array), is(result));
    }
}
