package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11126Test {
    @Test
    public void whenAskAboutWeightThenReturnTheResultOfMostFatAndMostThin() {
        Task11126 test = new Task11126();
        assertThat(test.weights(new int[]{50, 40, 60, 70, 80, 56, 79}), is(false));
    }
}
