package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11145Test {
    Task11145 test = new Task11145();
    int[] evenArray = new int[]{1, 2, 3, 4, 5, 6};
    int[] notEvenArray = new int[]{1, 2, 3, 4, 5};

    @Test
    public void whenPutEvenArrayThenReturnItWithChangedHalfs() {
        assertThat(test.halfChange(evenArray), is(new int[]{4, 5, 6, 1, 2, 3}));
    }

    @Test
    public void whenPutNotEvenArrayThenReturnItWithChangedHalfs() {
        assertThat(test.halfChange(notEvenArray), is(new int[]{3, 4, 5, 1, 2}));
    }

    @Test
    public void whenPutEvenArrayThenMixIt() {
        assertThat(test.numbersMix(test.numbersMix(evenArray)), is(evenArray));
    }

    @Test
    public void whenPutNotEvenArrayThenMixIt() {
        assertThat(test.numbersMix(test.numbersMix(notEvenArray)), is(notEvenArray));
    }

    @Test
    public void whenPutEvenArrayThenTurnIt() {
        assertThat(test.turnArray(evenArray), is(new int[]{6, 5, 4, 3, 2, 1}));
    }

    @Test
    public void whenPutNotEvenArrayThenTurnIt() {
        assertThat(test.turnArray(notEvenArray), is(new int[]{5, 4, 3, 2, 1}));
    }
}
