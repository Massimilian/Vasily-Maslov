package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12167Test {
    int[][] array = {{1, 2}, {1}};
    Task12167 test = new Task12167();

    @Test
    public void whenTryToChangeToValuesThenDoIt() {
        test.changePlaces(array, 1, 0);
        assertThat(array[0][1], is(1));
        assertThat(array[1][0], is(2));
    }
}
