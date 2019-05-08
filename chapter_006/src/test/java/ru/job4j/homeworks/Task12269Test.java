package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12269Test {
    Task12269 test = new Task12269();
    int[][] count = {{0, 1}, {0, 1, 2, 3}, {1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6, 7}};
    int[] result = {0, 2, 2, 2, 4};
    int[] resultTwo = {1, 3, 3, 5, 7};

    @Test
    public void whenTryToFormTheArrayWithEvenNumbersThenDoIt() {
        assertThat(test.getEvens(count), is(result));
        assertThat(test.getNotEvens(count), is(resultTwo));
    }
}
