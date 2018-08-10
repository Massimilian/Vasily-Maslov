package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task13Test {
    private Task13 test = new Task13();
    private int[] array = {1, 1, 1};
    private int[] incorrectArray = {1, 1, 2, 1};

    @Test
    public void whenTryToCheckTheArrayWithEqualNumbersThenReturnTrueIfAllNumbersAreEquals() {
        assertThat(test.allEquals(array), is(true));
        assertThat(test.allEquals(incorrectArray), is(false));
    }
}
