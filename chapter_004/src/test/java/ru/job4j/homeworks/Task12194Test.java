package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12194Test {
    private Task12194 test = new Task12194();
    private int[][] array = {{1, 2, 3, 4}, {1}, {3, 5, 76}, {}};

    @Test
    public void whenAskToFillColumnOrStringWithNumberThenDoIt() {
        assertThat(test.changeColumnOrString(array, 2, 0, true), is(new int[][]{{1, 2, 0, 4}, {1}, {3, 5, 0}, {}}));
        assertThat(test.changeColumnOrString(array, 2, 0, false), is(new int[][]{{1, 2, 0, 4}, {1}, {0, 0, 0}, {}}));
    }
}
