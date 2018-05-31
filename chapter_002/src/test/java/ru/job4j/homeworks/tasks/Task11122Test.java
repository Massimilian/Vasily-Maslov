package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11122Test {

    @Test
    public void whenAskTheMostCheapBooksThenReturnHowMuchBooksHasLeft() {
        Task11122 test = new Task11122();
        assertThat(test.howMuchCheapBooks(new int[]{200, 200, 10, 20, 20, 10, 34, 23, 49, 34, 10, 34}), is(3));
    }
}
