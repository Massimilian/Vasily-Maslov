package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11Test {
    Task11 test = new Task11();
    int[] check = {0, 0, 1, 1, 1, 1};
    int[] correctCheck = {1, 1, 1, 1, 1, 1, 1, 1};

    @Test
    public void whenTryToCheckTheArrayThenReturnTheResult() {
        assertThat(test.allOnes(check), is(false));
        assertThat(test.allOnes(correctCheck), is(true));
    }
}
