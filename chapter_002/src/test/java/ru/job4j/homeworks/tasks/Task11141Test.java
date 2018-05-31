package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11141Test {
    @Test
    public void whenAskBestResultsThenReturnIt() {
        Task11141 test = new Task11141();
        assertThat(test.bestResults(new int[]{10, 9, 9, 10, 12, 13, 12, 11, 12, 12, 10, 10, 9}, 4), is(new int[]{1, 2, 3, 13}));
    }
}
