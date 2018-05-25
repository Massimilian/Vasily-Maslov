package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1138Test {

    Task1138 test = new Task1138();
    @Test
    public void whenPutANumberOfNumbersThenReturnTheseNumbers() {
        assertThat(test.arrNumbers(new int[]{1, 11, 111, 2, 22, 222, 2222, 3, 33, 333, 3333, 33333}, 2), is(new int[]{11, 22, 33}));
    }

    @Test
    public void whenPutANumberOfNumbersThenReturnTheseNumbersAnotherTry() {
        assertThat(test.arrNumbers(new int[]{1, 11, 111, 2, 22, 222, 2222, 3, 33, 333, 3333, 33333}, 3), is(new int[]{111, 222, 333}));
    }
}
