package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11166Test {
    Task11166 test = new Task11166();

    @Test
    public void whenAskToAddByHeightThenDoIt() {
        assertThat(test.addByHeight(new int[]{20, 19, 17, 16, 13, 12, 11}, new int[]{18, 15, 14, 10}), is(new int[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10}));
    }

    @Test
    public void whenAskToAddByNumberThenDoIt() {
        assertThat(test.addByNumber(new int[]{7, 6, 5, 3, 2}, new int[][]{{0, 8}, {3, 4}}), is(new int[]{8, 7, 6, 5, 4, 3, 2}));
    }
}
