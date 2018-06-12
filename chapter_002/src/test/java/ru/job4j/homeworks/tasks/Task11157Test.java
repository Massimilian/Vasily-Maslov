package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11157Test {
    Task11157 test = new Task11157();
    int[] pull = {0, 1, 3, 6, 10};

    @Test
    public void whenAskToDeleteAllEvenOnNotEvenPlacesThenDoIt() {
        assertThat(test.deleteAllEvenOnAntiEvenPlaces(pull), is(new int[]{0, 1, 3, 10}));
    }

    @Test
    public void whenAskToDeleteAllDivisibleNumbersThenDoIt() {
        assertThat(test.deleteAllChangedDivisible(pull, new int[]{3, 5}), is(new int[]{0, 1}));
    }
}