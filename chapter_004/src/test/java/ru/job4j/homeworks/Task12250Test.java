package ru.job4j.homeworks;


import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12250Test {
    Task12250 test = new Task12250(new int[]{5, 5, 5});
    int[][] pupils = {{5, 4, 5}, {4, 4, 5}, {3, 5, 4}, {5, 5, 5}};
    int[][] result = {{5, 5, 5}, {5, 4, 5}, {4, 4, 5}, {3, 5, 4}, {5, 5, 5}};

    @Test
    public void whenTryToPutTheNewPupilThenDoit() {
        assertThat(test.renovatePupils(pupils, 0), is(result));
    }

}
