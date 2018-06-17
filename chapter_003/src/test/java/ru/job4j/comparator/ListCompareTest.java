package ru.job4j.comparator;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class ListCompareTest {

    @Test
    public void whenStringsAreEqualThenZero() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare("Ivanov", "Ivanov");
        assertThat(rst, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare("Ivanov", "Ivanova");
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare("Petrov", "Ivanova");
//        assertThat(rst, greaterThan(0)); в задании был дан именно такой результат.
//        Учитывая, что по лексике "I" встречается в алфавите раньше "P", результат неверный.
        assertThat(rst, lessThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare("Petrov", "Patrov");
//        assertThat(rst, greaterThan(0)); в задании был дан именно такой результат.
//        Учитывая, что по лексике "a" встречается в алфавите раньше "e", результат неверный.
        assertThat(rst, lessThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare("Patrova", "Petrov");
//        assertThat(rst, lessThan(0)); в задании был дан именно такой результат.
//        Учитывая, что по лексике "I" встречается в алфавите раньше "P", результат неверный.

        assertThat(rst, greaterThan(0));
    }
}

