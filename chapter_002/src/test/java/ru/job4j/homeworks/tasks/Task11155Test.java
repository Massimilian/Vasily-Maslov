package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11155Test {
    Task11155 test = new Task11155();
    int[] ask = {10, 11, 12, 13, 14};
    int[] result = {10, 12, 14};

    @Test
    public void whenAskToDeleteTwoPupilsByHeightThenDoIt() {
        assertThat(test.deleteTwoPupilsByHeight(ask, 11, 13), is(result));
    }

    @Test
    public void whenAskToDeleteTwoPupilsByPositionThenDoIt() {
        assertThat(test.deleteTwoPupilsByCount(ask, 2, 4), is(result));
    }

    @Test
    public void whenAskToDeleteRandomNumberOfPupilsThenDoIt() {
        assertThat(test.deleteRandomNumberOfPupilsByHeight(ask, ask), is(new int[]{}));
    }

    @Test
    public void whenAskToDeleteRandomNumberOfPupilsThenDoItAnotherTry() {
        assertThat(test.deleteRandomNumberOfPupilsByHeight(ask, result), is(new int[]{11, 13}));
    }

    @Test
    public void whenAskToDeleteRandomNumberOfPupilsThenDoItErrorTry() {
        assertThat(test.deleteRandomNumberOfPupilsByHeight(result, ask), is(new int[]{}));
    }
}
