package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1157Test {
    @Test
    public void whenAskTheSumOfRainInTheEvenDaysThenReturnIt() {
        Task1157 test = new Task1157();
        assertThat(test.sumOfRains(new int[]{2, 3, 1, 4, 3, 2, 4, 5, 3, 4, 2, 2, 3, 1, 2, 3, 2, 3, 2, 4, 5, 3, 2, 4, 4, 5, 6, 5, 6, 6, 6}), is(54));
    }
}
