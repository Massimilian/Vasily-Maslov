package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1230Test {
    Task1230 test = new Task1230();

    @Test
    public void whenTryToConstructTheNoEvenMatrixThenDoIt() {
        assertThat(test.snakeNumbers(3), is(new int[][]{{1, 8, 7}, {2, 9, 6}, {3, 4, 5}}));
    }

    @Test
    public void whenTryToConstructTheEvenMatrixThenDoIt() {
        assertThat(test.snakeNumbers(2), is(new int[][]{{1, 4}, {2, 3}}));
    }
}
