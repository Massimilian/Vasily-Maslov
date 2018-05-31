package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11124Test {
    @Test
    public void whenAskPlacesOfMinAndMaxThenReturnItInMatrixFormat() {
        Task11124 test = new Task11124();
        assertThat(test.maxMinSearch(new int[]{1, 2, 2, 1, 0, 1, 2, 3, 3, 2, 0, 3, 2, 3, 1, 0}), is(new int[][]{{5, 11, 16}, {8, 9, 12, 14}}));
    }
}
