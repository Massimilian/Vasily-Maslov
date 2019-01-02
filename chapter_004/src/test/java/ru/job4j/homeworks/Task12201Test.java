package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12201Test {
    private Task12201 test = new Task12201();
    private int[][] array = {{1, 4, 3}, {Integer.MIN_VALUE, Integer.MAX_VALUE, 575657}, {0, -132, -1, -1}};
    private int[][] result = {{4, 1, 3}, {Integer.MAX_VALUE, Integer.MIN_VALUE, 575657}, {0, -132, -1, -1}};

    @Test
    public void whenTryToChangeArrayThenDoIt() {
        assertThat(test.changeElement(array), is(result));
    }
}
