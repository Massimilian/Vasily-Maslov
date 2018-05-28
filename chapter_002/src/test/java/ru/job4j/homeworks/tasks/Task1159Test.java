package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1159Test {

    @Test
    public void whenAskTheResultOfDivisionThenReturnIt() {
        Task1159 test = new Task1159();
        assertThat(test.quotient(new int[]{1, 0, -2}), is(0.5d));
    }
}
