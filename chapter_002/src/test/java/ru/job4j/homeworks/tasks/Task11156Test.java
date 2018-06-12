package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11156Test {
    Task11156 test = new Task11156();
    int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10, 10};

    @Test
    public void whenAskToDeleteAllSubzeroThenDoIt() {
        assertThat(test.deleteAllSubzero(array), is(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    @Test
    public void whenAskToDeleteAllNumbersBiggerThenSomethinfThenDoIt() {
        assertThat(test.deleteAllBiggerThen(array, -10), is(new int[]{-10}));
    }

    @Test
    public void whenAskToDeleteAllNumbersBetweenAAndBThenDoIt() {
        assertThat(test.deleteNumbersBetween(array, -9, 9), is(new int[]{9, -9, -10, 10}));
    }
}
