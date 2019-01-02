package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12206Test {
    private Task12206 test = new Task12206();
    private int[][] array = {{-2, -1}, {0, 1, 2}, {3, 4, 5}, {6, 7, 8, 9}};
    private int[][] firstResult = {{-4, -1}, {0, 1, 2}, {3, 7, 5}, {12, 7, 14, 9}};
    private int[][] secondResult = {{-4, -1}, {0, 1, 4}, {3, 7, 5}, {108, 7, 14, 9}};
    private int[][] thirdResult = {{-8, -5}, {0, 5, 8}, {8, 12, 10}, {117, 16, 23, 18}};
    private int[][] forthResult = {{-8, -5}, {0, 5, 8}, {8, 12, 10}, {117, 16, 0, 18}};

    @Test
    public void whenTryToMakeAllChangesThenDoIt() {
        assertThat(test.changeEvens(array), is(firstResult));
        assertThat(test.changeNumbersWithTwo(array), is(secondResult));
        assertThat(test.changePositives(array), is(thirdResult));
        assertThat(test.changeFifth(array), is(forthResult));
    }
}
