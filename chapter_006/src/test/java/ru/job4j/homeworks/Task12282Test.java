package ru.job4j.homeworks;

import org.junit.Test;
import ru.job4j.homeworks.task12282.Task12282;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12282Test {
    Task12282 test = new Task12282();
    char[] one = {'a', 'b', 'c', 'd'};
    char[][] testing = {{'a', 'b', 'c', 'd', 'e'}, one, {'a', 'b', 'c'}, {'a'}, one, {'a'}, {'b', 'b', 'c'}};

    @Test
    public void whenTryToCheckEqualOrNotThenDoIt() {
        assertThat(test.testing(testing, 1, 4), is(true));
        assertThat(test.testing(testing, 3, 5), is(true));
        assertThat(test.testing(testing, 0, 1), is(false));
        assertThat(test.testing(testing, 2, 6), is(false));
    }
}
