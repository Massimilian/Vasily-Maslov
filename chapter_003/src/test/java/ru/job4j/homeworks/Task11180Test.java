package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11180Test {

    @Test
    public void whenAskInfoAboutFirstAndLastNumberThenReturnIt() {
        Task11180 test = new Task11180();
        assertThat(test.findAll(new int[]{3, 5, 6, 5, 5, 4, 3}, 5), is("Минимальная позиция = 2, максимальная позиция = 5."));
    }
}
