package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1238Test {
    private Task1238 test = new Task1238();

    @Test
    public void whenNeedToGetInfoAboutSumOfCountsTheReturnIt() {
        assertThat(test.countInfo(new int[][]{{5, 5, 5}, {4, 5, 5}, {4, 5, 4}, {4, 4, 4}, {4, 5, 5}}, 3), is(13));
    }
}
