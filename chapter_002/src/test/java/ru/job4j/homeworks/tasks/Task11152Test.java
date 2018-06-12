package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11152Test {
    Task11152 test = new Task11152();
    int[] pupils = {10, 11, 12};
    int[] result = {10, 12};

    @Test
    public void whenAskArrayWithPupilsAfterDeleteByPositionThenReturnIt() {
        assertThat(test.minusPupilByPoint(pupils, 2), is(result));
    }

    @Test
    public void whenAskArrayWithPupilsAfterDeleteByHeightThenReturnItRightMode() {
        assertThat(test.minusPupilByHeight(pupils, 11), is(result));
    }

    @Test
    public void whenAskArrayWithPupilsAfterDeleteByHeightThenReturnItWrongMode() {
        assertThat(test.minusPupilByHeight(pupils, 14), is(pupils));
    }
}
