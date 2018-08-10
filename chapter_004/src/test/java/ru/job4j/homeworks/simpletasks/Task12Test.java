package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12Test {
    private Task12 test = new Task12();
    private int[] array = {1, 2, 3, 2, 1, 2, 1, 1, 11, 1, 1, 1, 2, 4, 1};
    private int[] incorrectArray = {1, 1, 11, 1, 1, 11, 2, 2, 2, 2, 2, 11, 1, 11, 1, 11, 11, 11};

    @Test
    public void whenTryToCheckTheArrayWithThreeOnesThenReturnTrueIfContainsThreeOnes() {
        assertThat(test.threeOnes(array), is(true));
        assertThat(test.threeOnes(incorrectArray), is(false));
    }
}
