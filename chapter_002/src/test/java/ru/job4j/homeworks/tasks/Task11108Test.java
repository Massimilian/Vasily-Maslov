package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11108Test {

    @Test
    public void whenAskTheMostBigBookThenReturnTheNumberOfPages() {
        Task11108 test = new Task11108();
        assertThat(test.findTheBiggest(new int[]{656, 445, 35, 656, 45, 767, 757, 545, 35, 455}), is(767));
    }
}
