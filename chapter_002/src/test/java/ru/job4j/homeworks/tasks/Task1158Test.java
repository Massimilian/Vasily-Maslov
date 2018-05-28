package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1158Test {

    @Test
    public void whenAskInfoAboutYearWeatherThenReturnInfoAboutRains() {
        Task1158 test = new Task1158();
        int[] year = {56, 59, 60, 80, 75, 60, 60, 63, 80, 50, 20, 15};
        int[] monthes = {3, 6, 9, 12};
        assertThat(test.yearRainInfo(year, monthes), is(215));
    }
}
