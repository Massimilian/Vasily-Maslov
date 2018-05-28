package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11107Test {

    @Test
    public void whenPutArrayThenReturnInfoAboutIt() {
        Task11107 test = new Task11107();
        assertThat(test.getInfo(new int[]{1, 3, 5, 7, 9, 11, -1}), is(new int[]{11, -1, 12, 5, 6}));
    }
}
