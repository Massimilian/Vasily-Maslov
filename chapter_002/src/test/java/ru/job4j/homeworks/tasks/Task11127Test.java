package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11127Test {
    @Test
    public void whenAskAboutNumberOfPupilsInTwoClassesThenReturnInformationAboutDifferenceOfTenPupilsBetweenThen() {
        Task11127 test = new Task11127();
        assertThat(test.classes(new int[]{25, 26, 27, 26, 27, 28, 27, 28, 29, 20, 29, 30, 27, 26, 28, 27, 25, 24, 24, 20}), is(true));
    }
}
