package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11111Test {

    @Test
    public void whenAskTheBestResultThenReturnIt() {
        Task11111 test = new Task11111();
        assertThat(test.resultArray(new int[]{5, 7, 6, 7, 5, 8, 4, 5}), is(4));
    }
}
