package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1160Test {
    Task1160 test = new Task1160();

    @Test
    public void whenTheSumOfBigNumbersInArrayIsBiggerThenHundredThenReturnTrue() {
        assertThat(test.bigSum(new int[]{1, 2, 3, 12, 15}), is(false));
    }

    @Test
    public void whenTheDivisionOfSmallestNumbersIsEvenThenReturnTrue() {
        assertThat(test.evenSum(new int[]{1, 2, 3, 4, 51}), is(true));
    }
}
