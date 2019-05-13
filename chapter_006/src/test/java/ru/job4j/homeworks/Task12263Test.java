package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12263Test {
    Task12263 test = new Task12263();
    int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    int[] upDiagonalResult = {1, 2, 3, 5, 6, 9};
    int[] downDiagonalResult = {8, 11, 12, 14, 15, 16};
    int[] upSecondDiagonalResult = {2, 3, 4, 7, 8, 12};
    int[] downSecondDiagonalResult = {5, 9, 10, 13, 14, 15};

    @Test
    public void whenTryToUseUpDiagonalMethodThenReturnCorrectArray() {
        assertThat(test.upDiagonal(array), is(upDiagonalResult));
    }

    @Test
    public void whenTryToUseDownDiagonalMethodThenReturnCorrectArray() {
        assertThat(test.downDiagonal(array), is(downDiagonalResult));
    }

    @Test
    public void whenTryToUseAnotherDiagonalMethodThenReturnCorrectArray() {
        assertThat(test.upSecondDiagonal(array), is(upSecondDiagonalResult));
    }

    @Test
    public void whenTryToUseAnotherDownDiagonalMethodThenReturnCorrectArray() {
        assertThat(test.downSecondDiagonal(array), is(downSecondDiagonalResult));
    }
}
