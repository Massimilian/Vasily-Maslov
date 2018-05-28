package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1142Test {

    @Test
    public void whenAskTheNumbersIfTheMembersOfArrayThenDivisibleTenThenReturnAllNumbers() {
        Task1142 test = new Task1142();
        assertThat(test.findZeroNumbers(new int[]{9, 10, 12, 13, 60, 4, 3, 5, 30}), is(new int[]{2, 5, 9}));
    }
}
