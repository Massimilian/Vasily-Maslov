package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11168Test {

    @Test
    public void whenAddTheArrayWithANumberThenReturnItChanged() {
        Task11168 test = new Task11168();
        assertThat(test.enterNumber(new int[]{1, 1, -1, -1, -1}, 0), is(new int[]{1, 0, 1, -1, 0, -1, 0, -1}));
    }
}
