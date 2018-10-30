package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12166Test {
    Task12166 test = new Task12166();
    int[][] array = {{1}, {0, 2}};

    @Test
    public void whenAskToChangeTwoNumbersThenDoIt() {
        test.changePlaces(array, 0, 1);
        assertThat(array[0][0], is(2));
        assertThat(array[1][1], is(1));
    }
}
