package ru.job4j.homeworks.simpletasks.task19;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task19Test {
    private Task19 test = new Task19();
    private Task19 another = new Task19();
    private int[][] array = {{1, 1, 1, 0, 0}, {1, 0, 1, 0, 0}, {0, 1, 1, 1, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 1}};

//   EasyArray - 1
//    *1100
//    10100
//    01110
//    010*0
//    01011

//   EasyArray - 1
//    11100
//    10100
//    01110
//    010*0
//    0*011


    @Test
    public void whenTryToGoThrowLabThenDoItMustFastWay() {
        assertThat(test.findExit(array, 0, 0, 3, 3), is(new int[][]{{1, 2, 3, 0, 0}, {0, 0, 4, 0, 0}, {0, 0, 5, 6, 0}, {0, 0, 0, 7, 0}, {0, 0, 0, 0, 0}}));
    }

    @Test
    public void whenTryToGoThrowLabThenDoItAnotherWay() {
        assertThat(test.findExit(array, 3, 1, 3, 3), is(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 2, 3, 4, 0}, {0, 1, 0, 5, 0}, {0, 0, 0, 0, 0}}));
    }
}
