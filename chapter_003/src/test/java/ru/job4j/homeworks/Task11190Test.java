package ru.job4j.homeworks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11190Test {
    Task11190 test = new Task11190();

    @Test
    public void whenAskHowManyElementsNotRepeatedThenTellUs() {
        assertThat(test.numberOfDiffElements(new int[]{1, 2, 3, 4, 5, 1, 3, 5}), is(2));
    }

    @Test
    public void whenAskHowManyElementsNotRepeatedThenTellUsZeroVersion() {
        assertThat(test.numberOfDiffElements(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}), is(0));
    }

}
