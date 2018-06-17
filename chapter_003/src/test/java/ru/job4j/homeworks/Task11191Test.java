package ru.job4j.homeworks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11191Test {
    Task11191 test = new Task11191();

    @Test
    public void whenAskHowManyRepeatedNumbersThenTellUs() {
        assertThat(test.equalsNumbers(10000), is(2));
    }

    @Test
    public void whenAskHowManyRepeatedNumbersThenTellUsAnotherVersion() {
        assertThat(test.equalsNumbers(11111), is(1));
    }

    @Test
    public void whenAskHowManyRepeatedNumbersThenTellWithoutRepetitions() {
        assertThat(test.equalsNumbers(1234567890), is(10));
    }

}
