package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12240Test {
    Task12240 test = new Task12240();
    int[][] array = {{1, 0, 4}, {2, 4}, {1, 3}};
    int[][] anotherArray = {{1, 2, 3, 4, 5}, {1, 2, 0, 3, 4}, {}, {1, 2}};
    int[][] result = {{2}, {1}};
    int[][] anotherResult = {{1, 2, 4, 5}, {}, {1, 2}};

    @Test
    public void whenTryToPrepareArrayThenDoItWell() {
        assertThat(test.modifyArray(array), is(result));
        assertThat(test.modifyArray(anotherArray), is(anotherResult));
    }
}
