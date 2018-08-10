package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task18Test {
    private Task18 test = new Task18();
    private int[][] counts = {{1, 1, 0}, {1, 0, 1, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1}, {1}, {1, 1, 1, 0, 1, 1, 1}};

    @Test
    public void whenTryToFindMaxNeighbourNumbersThenDoIt() {
        assertThat(test.numberOfNums(counts, 1), is(4));
    }
}
