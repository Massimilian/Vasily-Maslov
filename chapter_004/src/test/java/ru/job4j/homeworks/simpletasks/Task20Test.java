package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task20Test {
    private Task20 test = new Task20();
    private int[] arrayOne = {1};
    private int[] arrayTwo = {10, 12};
    private int[] arrayThree = {100, 1, -26580};
    private int[] arrayTen = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    public void whenTryToRechangeInAllVariationsThenDoIt() {
        assertThat(test.rechanges(arrayOne), is(new int[][]{{1}}));
        assertThat(test.rechanges(arrayTwo), is(new int[][]{{12, 10}, {10, 12}}));
        assertThat(test.rechanges(arrayThree).length, is(6));
        assertThat(test.rechanges(arrayTen).length, is(3628800));
    }
}
