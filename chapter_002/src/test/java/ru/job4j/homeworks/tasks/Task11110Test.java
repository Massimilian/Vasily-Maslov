package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11110Test {

    @Test
    public void whenAskMinPriceThenTellIt() {
        Task11110 test = new Task11110();
        assertThat(test.minPrice(new int[]{23, 43, 42, 23, 45, 22}), is(22));
    }
}
