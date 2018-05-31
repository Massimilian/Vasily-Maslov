package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11125Test {
    @Test
    public void whenAskAboutArrayThenReturnAnswers() {
        Task11125 test = new Task11125();
        assertThat(test.getAnswers(new int[]{1, 2, 4, 8, 16, 32, 64}), is(new boolean[]{false, true}));
    }
}
