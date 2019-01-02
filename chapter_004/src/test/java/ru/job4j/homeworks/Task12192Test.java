package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12192Test {
    private Task12192 test = new Task12192();
    private int[][] array = {{1, 2}, {3, 4, 5}};
    private int[][] afterFirstChange = {{5, 2}, {3, 4, 1}};
    private int[][] afterSecondChange = {{5, 3}, {2, 4, 1}};

    @Test
    public void whenTryToChangeArrayThenDoIt() {
        assertThat(test.changes(array, 1), is(afterFirstChange));
        assertThat(test.changes(array, 2), is(afterSecondChange));
    }
}
