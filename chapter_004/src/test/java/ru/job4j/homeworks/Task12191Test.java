package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12191Test {
    Task12191 test = new Task12191();
    private int[][] array = {{0, 1, 1, 1, 0}, {2, 0, 1, 0, 3}, {2, 2, 0, 3, 3}, {2, 0, 4, 0, 3}, {0, 4, 4, 4, 0}};
    private int[][] arrayAfterFirstChange = {{0, 4, 4, 4, 0}, {2, 0, 4, 0, 3}, {2, 2, 0, 3, 3}, {2, 0, 1, 0, 3}, {0, 1, 1, 1, 0}};
    private int[][] arrayAfterSecondChange = {{0, 1, 1, 1, 0}, {3, 0, 1, 0, 2}, {3, 3, 0, 2, 2}, {3, 0, 4, 0, 2}, {0, 4, 4, 4, 0}};
    private int[][] arrayAfterThirdChange = {{0, 2, 2, 2, 0}, {1, 0, 2, 0, 3}, {1, 1, 0, 3, 3}, {1, 0, 4, 0, 3}, {0, 4, 4, 4, 0}};
    private int[][] arrayAfterForthChange = {{0, 1, 1, 1, 0}, {2, 0, 1, 0, 4}, {2, 2, 0, 4, 4}, {2, 0, 3, 0, 4}, {0, 3, 3, 3, 0}};
    private int[][] arrayAfterFifthChange = {{0, 3, 3, 3, 0}, {2, 0, 3, 0, 1}, {2, 2, 0, 1, 1}, {2, 0, 4, 0, 1}, {0, 4, 4, 4, 0}};
    private int[][] arrayAfterSixthChange = {{0, 1, 1, 1, 0}, {4, 0, 1, 0, 3}, {4, 4, 0, 3, 3}, {4, 0, 2, 0, 3}, {0, 2, 2, 2, 0}};
    private int[][] evenArray = {{0, 1, 1, 0}, {2, 0, 0, 3}, {2, 0, 0, 3}, {0, 4, 4, 0}};
    private int[][] evevArrayAfterFirstChange = {{0, 4, 4, 0}, {2, 0, 0, 3}, {2, 0, 0, 3}, {0, 1, 1, 0}};
    private int[][] evenArrayAfterSecondChange = {{0, 1, 1, 0}, {3, 0, 0, 2}, {3, 0, 0, 2}, {0, 4, 4, 0}};
    private int[][] evenArrayAfterThirdChange = {{0, 2, 2, 0}, {1, 0, 0, 3}, {1, 0, 0, 3}, {0, 4, 4, 0}};
    private int[][] evenArrayAfterForthChange = {{0, 1, 1, 0}, {2, 0, 0, 4}, {2, 0, 0, 4}, {0, 3, 3, 0}};
    private int[][] evenArrayAfterFifthChange = {{0, 3, 3, 0}, {2, 0, 0, 1}, {2, 0, 0, 1}, {0, 4, 4, 0}};
    private int[][] evenArrayAfterSixthChange = {{0, 1, 1, 0}, {4, 0, 0, 3}, {4, 0, 0, 3}, {0, 2, 2, 0}};
    private int upAndDown = 1;
    private int rightAndLeft = 2;
    private int topAndLeft = 3;
    private int bottomAndRight = 4;
    private int upAndRight = 5;
    private int leftAndDown = 6;

    @Test
    public void whenTryToUseThisChangerUpAndDownThenDoAllFuncionsGood() {
        assertThat(test.turnArray(array, upAndDown), is(arrayAfterFirstChange));
        assertThat(test.turnArray(evenArray, upAndDown), is(evevArrayAfterFirstChange));
    }

    @Test
    public void whenTryToUseThisChangerRightAndLeftThenDoAllFuncionsGood() {
        assertThat(test.turnArray(array, rightAndLeft), is(arrayAfterSecondChange));
        assertThat(test.turnArray(evenArray, rightAndLeft), is(evenArrayAfterSecondChange));
    }

    @Test
    public void whenTryToUseThisChangerTopAndLeftThenDoAllFuncionsGood() {
        assertThat(test.turnArray(array, topAndLeft), is(arrayAfterThirdChange));
        assertThat(test.turnArray(evenArray, topAndLeft), is(evenArrayAfterThirdChange));
    }

    @Test
    public void whenTryToUseThisChangerBottomAndRightThenDoAllFuncionsGood() {
        assertThat(test.turnArray(array, bottomAndRight), is(arrayAfterForthChange));
        assertThat(test.turnArray(evenArray, bottomAndRight), is(evenArrayAfterForthChange));
    }

    @Test
    public void whenTryToUseThisChangerTopAndRightThenDoAllFuncionsGood() {
        assertThat(test.turnArray(array, upAndRight), is(arrayAfterFifthChange));
        assertThat(test.turnArray(evenArray, upAndRight), is(evenArrayAfterFifthChange));
    }

    @Test
    public void whenTryToUseThisChangerLeftAndBottomThenDoAllFuncionsGood() {
        assertThat(test.turnArray(array, leftAndDown), is(arrayAfterSixthChange));
        assertThat(test.turnArray(evenArray, leftAndDown), is(evenArrayAfterSixthChange));
    }
}
