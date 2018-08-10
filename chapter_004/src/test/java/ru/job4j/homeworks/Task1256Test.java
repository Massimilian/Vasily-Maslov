package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1256Test {
    private Task1256 test = new Task1256();
    private int[][] release = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10}};

    @Test
    public void whenTryToCheckMethodsThenAllMethodsAreWorkingWell() {
        assertThat(test.sum(release), is(55));
        assertThat(test.pow(release), is(385));
        assertThat(test.middle(release), is(5.5));
    }
}
