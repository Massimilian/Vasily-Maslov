package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12264Test {
    Task12264 test = new Task12264();
    int[][] array = {{-5, -4, -3, -2, -1, 0}, {1, 2, 3}, {4, 5, 6}, {7, 8}, {9}, {}, {10}, {-6, -7, -8, -9, -10}};
    int[] resThrees = {-3, 3, 6, 9, -6, -9};
    int[] positives = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] negatives = {-5, -4, -3, -2, -1, -6, -7, -8, -9, -10};
    int[][] both = {positives, negatives};

    @Test
    public void whenTryToTakeAllThreesThenDoIt() {
        assertThat(test.returnThrees(array), is(resThrees));
    }

    @Test
    public void whenTryToSeparateNegativesAndPositivesThenDoIt() {
        assertThat(test.returnPosAndNeg(array), is(both));
    }
}
