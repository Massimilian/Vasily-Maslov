package ru.job4j.homeworks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11237Test {
    private Task11237 test = new Task11237();

    @Test
    public void whenAskPrepareArrayThenReturnItPrepared() {
        assertThat(test.makeArray(new int[]{1, 2, 3, 4, 5}), is(new int[]{1, 2, 3, 12, 5}));
    }

    @Test
    public void whenAskPrepareListThenReturnItPrepared() {
        assertThat(test.makeList(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5))), is(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 12, 5))));
    }
}
