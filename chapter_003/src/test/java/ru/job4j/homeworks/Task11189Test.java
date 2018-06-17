package ru.job4j.homeworks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11189Test {
    Task11189 test = new Task11189();

    @Test
    public void whenTryToGetSumFromBigNumbersThenTakeIt() {
        assertThat(test.bigSumAndDifference("9999", "2", "+"), is("10001"));
    }

    @Test
    public void whenTryToGetDifferenceFromBigNumbersThenTakeIt() {
        assertThat(test.bigSumAndDifference("1991", "999", "-"), is("992"));
    }

    @Test
    public void whenTryToGetDifferenceFromBigNumbersSecondMoreBigThenTakeIt() {
        assertThat(test.bigSumAndDifference("999", "1991", "-"), is("-992"));
    }

    @Test
    public void whenTryToGetDifferenceFromBigNumbersSecondSubzeroThenTakeIt() {
        assertThat(test.bigSumAndDifference("9", "-1991", "-"), is("2000"));
    }

    @Test
    public void whenTryToGetDifferenceFromBigNumbersBothSubzeroThenTakeIt() {
        assertThat(test.bigSumAndDifference("-1991", "-1991", "-"), is("0"));
    }

    @Test
    public void whenTryToGetDifferenceFromBigNumbersFirstSubzeroThenTakeIt() {
        assertThat(test.bigSumAndDifference("-1991", "1991", "-"), is("-3982"));
    }


    @Test
    public void whenTryToGetDifferenceFromBigNumbersErrorValueThenTakeIt() {
        assertThat(test.bigSumAndDifference("-1991", "1991", "o"), is("ERROR!"));
    }

}
