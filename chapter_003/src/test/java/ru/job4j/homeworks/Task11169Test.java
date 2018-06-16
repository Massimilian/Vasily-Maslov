package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11169Test {

    @Test
    public void whenAskToPrepareArrayThenDoIt() {
        Task11169 test = new Task11169();
        assertThat(test.replaceElement(new int[]{1, 2, 5, 3, 4}, 3), is(new int[]{1, 2, 3, 4, 5}));
    }
}
