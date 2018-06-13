package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11161Test {

    @Test
    public void whenAddNewInformationThenPutItOn() {
        Task11161 test = new Task11161();
        int[] mountains = {45, 56, 67, 89};
        assertThat(test.addMountain(mountains, 78, 4), is(new int[]{45, 56, 67, 78, 89}));
    }
}
