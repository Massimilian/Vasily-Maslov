package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1274Test {
    Task1274 test = new Task1274();
    int[][] array = {{1, 1, 2}, {1, 2, 3, 5, 7, 9}, {1, 2, 4, 5}, {1, 0, 0, 0}};

    @Test
    public void whenTryToCountNumberOfDifferentDublesThenReturnTheCorrectResult() {
        assertThat(test.stringPares(array), is(2));
        assertThat(test.postPares(array), is(4));
        assertThat(test.allPares(array), is(6));
    }

}
