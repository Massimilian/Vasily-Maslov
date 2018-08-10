package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1219Test {
    int[][] result = {{1, 3, 8}, {2, 9}, {1, 4, 7, 3, 4}, {}};
    Task1219 test = new Task1219();

    @Test
    public void whenAskIfTheNumberIsMaxInDoubleArrayThenReturnInfo() {
        assertThat(test.isMax(result), is(false));
    }

    @Test
    public void whenAskWhichNumberIsBiggerthenTellTrueIfFirstIsBigger() {
        assertThat(test.isBigger(result, 0, 2, 2, 4), is(true));
    }
}
