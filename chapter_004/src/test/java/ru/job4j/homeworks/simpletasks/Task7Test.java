package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task7Test {
    Task7 test = new Task7();

    @Test
    public void whenTryToUseCalculatorTheDoItWell() {
        assertThat(test.counting("6/  2*3-1 9+ 8e2="), is(4.0));
    }

}
