package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11162Test {
    Task11162 test = new Task11162();
    int[] pupils = {50, 51, 52, 54, 55};

    @Test
    public void whenAskToPutANewPupilByHeightThenDoIt() {
        pupils = test.addNewPupil(pupils, 53);
        assertThat(pupils, is(new int[]{50, 51, 52, 53, 54, 55}));
    }

    @Test
    public void whenAskToPutANewPupilByPositionAndHeightThenDoIt() {
        pupils = test.addNewPupilWithNumber(pupils, 53, 4);
        assertThat(pupils, is(new int[]{50, 51, 52, 53, 54, 55}));
    }
}
