package ru.job4j.homeworks;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11247Test {
    int[] one = {-1, 1, 2, -2};
    int[] two = {-1, 1, -2, -3, 4};
    Task11247 test = new Task11247();

    @Test
    public void whenAddTwoArraysThenReturnInfoAboutTheNumbers() {
        assertThat(test.resultMass(one, two), is(new int[]{1, 1, 0, 1}));
    }

    @Test
    public void whenAddTwoArraysThenReturnInfoAboutTheNumbersArrayWay() {
        assertThat(test.resultArray(one, two), is(new ArrayList<>(Arrays.asList(1, 1, 0, 1))));
    }
}
