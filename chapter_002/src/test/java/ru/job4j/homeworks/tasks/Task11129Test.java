package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11129Test {
    @Test
    public void whenAskWhoIsTheFirstThenReturnAnAnswer() {
        Task11129 test = new Task11129();
        assertThat(test.youngOrOld(new int[]{25, 43, 35, 45, 24}), is("First is the most old"));
    }
}
