package ru.job4j.homeworks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11236Test {
    Task11236 test = new Task11236();

    @Test
    public void whenAskToPrepareArrayThenDoIt() {
        assertThat(test.editArray(new int[]{1, 2, 3, 4, 5}), is(new int[]{1, 4, 9, 8, 25}));
    }

    @Test
    public void whenAskToPrepareListThenDoIt() {
        assertThat(test.editList(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5))), is(new ArrayList<Integer>(Arrays.asList(1, 4, 9, 8, 25))));
    }
}
