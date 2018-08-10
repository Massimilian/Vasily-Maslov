package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task17Test {
    private Task17 test = new Task17();

    @Test
    public void whenGiveBanknoteThenReturnAllPossiblesRechanges() {
        assertThat(test.change(0.02).size(), is(2));
        assertThat(test.change(2).size(), is(73682));
    }
}
