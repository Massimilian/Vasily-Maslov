package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1272Test {
    Task1272 test = new Task1272();
    int[][] array = {{1, 2, 3}, {4}, {5, 6}, {7, 8, 9, 0}};

    @Test
    public void whenTryToUseAllMethodsThenWorkWellAll() {
        assertThat(test.sumOfEven(array), is(20));
        assertThat(test.smallerThen(array, 9), is(9));
        assertThat(test.middleOfNotEven(array), is(5.0));
        assertThat(test.sumOfEveryThird(array), is(12));
    }
}
