package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1156Test {

    @Test
    public void whenAskNumbersFromArrayThenReturnTheSumOfThem() {
        Task1156 test = new Task1156();
        assertThat(test.sumOfSomeNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10), is(0));
    }
}
