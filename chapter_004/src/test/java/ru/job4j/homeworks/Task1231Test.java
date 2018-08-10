package ru.job4j.homeworks;

import org.junit.Test;

import java.util.HashSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1231Test {
    Task1231 test = new Task1231();
    int x = 1232;
    int y = 4549;

    @Test
    public void whenNeedToFillArrayWithRandomNotRepeatedNumbersThenDoIt() {
        int[][] result = test.differentNumbersArray(x, y);
        HashSet<Integer> check = new HashSet<>();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                check.add(result[i][j]);
            }
        }
        assertThat(check.size(), is(x * y));
    }
}
