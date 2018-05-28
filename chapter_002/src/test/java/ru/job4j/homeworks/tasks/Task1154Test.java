package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1154Test {

    Task1154 test = new Task1154();

    @Test
    public void whenAskTheSumOfSmallNumbersThenReturnIt() {
        assertThat(test.sumOfSmallNumbers(new int[]{1, 2, 3, 21, 22, 23}), is(6));
    }

    public void whenAskABigNumbersThenReturnIt() {
        assertThat(test.sumOfBiggerNumbers(new int[]{1, 2, 3, 4, 5}, 3), is(9));
    }
}
