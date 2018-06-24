package ru.job4j.homeworks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11214Test {
    Task11214 test = new Task11214();
    int[] arr1 = {1, 2, 3};
    int[] arr2 = {4, 5, 6};
    List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
    List<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6));


    @Test
    public void whenAddTwoArraysTheReturnTheSumOfElementsArrayStyle() {
        assertThat(test.sumOfSellings(arr1, arr2), is(21));
    }

    @Test
    public void whenAddTwoArraysTheReturnTheSumOfElementsListStyle() {
        assertThat(test.sumOfSellings(list1, list2), is((int) 21));
    }
}
