package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task16Test {
    private Task16 test = new Task16();
    private int[][] fieldZero = {{0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 1, 1}, {0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 1, 1}};
    private int[][] fieldOne = {{1, 1, 1}, {1, 0, 1}, {0, 1, 0}};
    private int[][] fieldTwo = {{1, 1, 0, 0}, {1, 0, 1, 1}, {1, 1, 0, 0}, {0, 1, 0, 1}};
    private int[][] fieldThree = {{1, 0, 0, 1}, {0, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 0}};
    private int[][] fieldFour = {{1, 0, 1, 1, 0}, {0, 1, 0, 0, 1}, {0, 0, 1, 1, 0}, {1, 1, 0, 0, 1}};

    @Test
    public void whenTryToLookForAWinnerThenReturnTrueIfTheWinnerIs() {
        assertThat(test.hasWinner(fieldZero, 3), is(false));
        assertThat(test.hasWinner(fieldOne, 3), is(true));
        assertThat(test.hasWinner(fieldTwo, 3), is(true));
        assertThat(test.hasWinner(fieldThree, 3), is(true));
        assertThat(test.hasWinner(fieldFour, 3), is(true));
    }
}
