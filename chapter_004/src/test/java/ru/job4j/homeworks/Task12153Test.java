package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12153Test {
    Task12153 test = new Task12153();
    int[][] array = {{-1, 2, 0, -7}, {4, 2, 0, 6}, {-2, 14, 0, 5}, {3, 6, 0, 1}};
    int[][] antiArray = {{1, -3, 0}, {3, 0, 1}, {0, -1, 3}};

    @Test
    public void whenAskHasColumnWithOnlyOneNumberThenGetAnswer() {
        assertThat(test.hasColumnWithOnlyNumber(array, 0), is(true));
        assertThat(test.hasColumnWithOnlyNumber(antiArray, 0), is(false));
    }

    @Test
    public void whenAskAboutColumnWithOnlySomeNumbersThenGetAnswer() {
        assertThat(test.hasColumnWithOnlySomeNumbers(array, 1, 4), is(true));
        assertThat(test.hasColumnWithOnlySomeNumbers(antiArray, 0, 2), is(false));
    }

    @Test
    public void whenAskAboutColumnsWithOnlyEvenNumbersThenGetAnswer() {
        assertThat(test.hasColumnWithOnlyEvens(array), is(true));
        assertThat(test.hasColumnWithOnlyEvens(antiArray), is(false));
    }

    @Test
    public void whenAskAboutColumnsHasColumnWithEqualNumberOfPositiveAndSubzeroThenGetAnswer() {
        assertThat(test.hasColumnWithEqualNumberOfPositiveAndSubzero(array), is(true));
        assertThat(test.hasColumnWithEqualNumberOfPositiveAndSubzero(antiArray), is(false));
    }

    @Test
    public void whenAskAboutColumnsHasColumnWithEqualsNumbers() {
        assertThat(test.hasColumnWithEquals(array), is(true));
        assertThat(test.hasColumnWithEquals(antiArray), is(false));
    }

    @Test
    public void whenAskAboutHasColumnWithThreeMinimumNumbers() {
        assertThat(test.hasColumnWithMinimums(array, 3), is(false));
        // assertThat(test.hasColumnWithMinimums(antiArray, 3), is(true));
    }
}
