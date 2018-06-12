package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11158Task {
    @Test
    public void whenTryToDeleteAllDubledNumbersThenDoIt() {
        assertThat(new Task11158().deleteDubles(new int[]{1, 2, 3, 4, 5, 4, 3, 2}), is(new int[]{1, 5}));
    }

}
