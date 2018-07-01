package ru.job4j.homeworks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11241Test {
    Task11241 test = new Task11241();
    int[] array = new int[]{1, 2, 3, 4, 5};
    ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));

    @Test
    public void whenAskArrayWithNullsThenReturnIt() {
        assertThat(test.completeArrayWithNulls(array), is(new int[]{0, 2, 0, 4, 0}));
    }

    @Test
    public void whenAskArrayWithoutNullsThenReturnIt() {
        assertThat(test.completeFullArray(array), is(new int[]{2, 4}));
    }

    @Test
    public void whenAskListWithNullsThenReturnIt() {
        assertThat(test.completeArrayWithNulls(list), is(new ArrayList<Integer>(Arrays.asList(0, 2, 0, 4, 0))));
    }

    @Test
    public void whenAskListWithoutNullsThenReturnIt() {
        assertThat(test.completeFullArray(list), is(new ArrayList<Integer>(Arrays.asList(2, 4))));
    }
}
