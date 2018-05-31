package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11130Test {
    Task11130 test = new Task11130();

    @Test
    public void whenAskAboutFootballThenGetAnAnswerAboutLose() {
        assertThat(test.info(new int[]{1, 1, 1, 0, 3}), is("Lose first"));
    }

    @Test
    public void whenAskAboutFootballThenGetAnAnswerAboutNoLosesNoWins() {
        assertThat(test.info(new int[]{1, 1, 1, 1, 1}), is("There were not loses and wins!"));
    }
}
