package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11128Test {
    @Test
    public void whenAskAboutNumbersInArrayThenReturnInformationAboutMaxOrMinNumber() {
        Task11128 test = new Task11128();
        assertThat(test.earlyNumber(new int[]{4}), is("Minimal == Maximal."));
    }
}
