package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12182Test {
    Task12182 test = new Task12182();
    int[][] array = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
    int[][] anotherArray = {{1, 2}, {3, 4}};

    @Test
    public void whenAskToShowUsHalfOfArrayThenDoIt() {
        assertThat(test.printHalf(array, true), is(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}}));
        assertThat(test.printHalf(array, false), is(new int[][]{{11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}));
    }

    @Test
    public void whenAskToShowUsHalfOfArrayThenDoItAnotherWay() {
        assertThat(test.printHalf(anotherArray, true), is(new int[][]{{1, 2}}));
        assertThat(test.printHalf(anotherArray, false), is(new int[][]{{3, 4}}));
    }
}
