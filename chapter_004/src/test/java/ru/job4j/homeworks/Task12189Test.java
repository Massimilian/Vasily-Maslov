package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12189Test {
    Task12189 test = new Task12189();
    int[][] array = {{1, 2, 3}, {2, 3, 2}, {3, 2, 1}};
    int[][] evenArray = {{1, 2, 3, 4}, {2, 3, 4, 3}, {3, 4, 3, 2}, {4, 3, 2, 1}};
    int[][] wrongArray = {{1, 3, 5}, {1, 3, 5}, {1, 3, 5}};

    @Test
    public void whenTryToLookIsTheArrayAreSimmetric() {
        assertThat(test.isSimm(array), is(true));
        assertThat(test.isSimm(evenArray), is(true));
        assertThat(test.isSimm(wrongArray), is(false));
    }
}
