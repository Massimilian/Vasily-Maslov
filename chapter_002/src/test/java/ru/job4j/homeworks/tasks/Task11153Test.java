package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11153Test {
    Task11153 test = new Task11153();
    int[] testArray = {0, 1, -1, 2, -2, 3, -3, 4, -4};
    int[] wrongArray = {0, 1, 3, 5, 7, 9, 11};

    @Test
    public void whenAskToDeleteFirstMinusNumberThenDoIt() {
        assertThat(test.deleteFirstSubzero(testArray), is(new int[]{0, 1, 2, -2, 3, -3, 4, -4}));
    }

    @Test
    public void whenAskToDeleteFirstMinusNumberThenDoItMistakeMode() {
        assertThat(test.deleteFirstSubzero(wrongArray), is(wrongArray));
    }

    @Test
    public void whenAskToDeleteLastEvenNumberThenDoIt() {
        assertThat(test.deleteLastEven(testArray), is(new int[]{0, 1, -1, 2, -2, 3, -3, 4}));
    }

    @Test
    public void whenAskToDeleteLastEvenNumberThenDoItMistakeMode() {
        assertThat(test.deleteLastEven(wrongArray), is(wrongArray));
    }
}
