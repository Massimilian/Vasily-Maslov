package ru.job4j.homeworks;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11246Test {
    private Task11246 test = new Task11246();
    int[] first = {1, 2, 3};
    int[] second = {3, 2, 1};
    ArrayList<Integer> listOne = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
    ArrayList<Integer> listTwo = new ArrayList<Integer>(Arrays.asList(3, 2, 1));

    @Test
    public void whenNeedToSumElementsAtArraysThenReturnIt() {
        assertThat(test.sum(first, second), is(new int[]{4, 4, 4}));
    }

    @Test
    public void whenNeedToCalculateElementsAtArraysThenReturnIt() {
        assertThat(test.theResult(first, second), is(new int[]{3, 4, 3}));
    }

    @Test
    public void whenNeedToFindMaxAtElementsOfArrayThenReturnIt() {
        assertThat(test.max(first, second), is(new int[]{3, 2, 3}));
    }

    @Test
    public void whenNeedToSumEementsAtArraysThenReturnItListWay() {
        assertThat(test.sum(listOne, listTwo), is(new ArrayList<Integer>(Arrays.asList(4, 4, 4))));
    }

    @Test
    public void whenNeedToCalculateElementsAtArraysThenReturnItListWay() {
        assertThat(test.theResult(listOne, listTwo), is(new ArrayList<Integer>(Arrays.asList(3, 4, 3))));
    }

    @Test
    public void whenNeedToFindMaxAtElementsOfArrayThenReturnItListWay() {
        assertThat(test.max(listOne, listTwo), is(new ArrayList<Integer>(Arrays.asList(3, 2, 3))));
    }
}
