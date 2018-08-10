package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task9Test {
    private Task9 test = new Task9();
    private String testThree = "qweqeweqweqeweqweqwewqeqeqweqqqqew";
    private String testEleven = "qwetoiyqwerouiqeytwpouiweyrpqwot qweptoi yqwety poqe pqouie oiqweu roiu weopir qpwoe poqiw epoiqeuwpioqpoe rpqueoi ";

    @Test
    public void whenTryToLookHowManyDifferentSymbolsInAStringThenReturnTheResult() {
        assertThat(test.lettersWithoutEasyWays(testThree), is(3));
        assertThat(test.letters(testThree), is(3));
        assertThat(test.lettersWithoutEasyWays(testEleven), is(11));
        assertThat(test.letters(testEleven), is(11));
    }
}
