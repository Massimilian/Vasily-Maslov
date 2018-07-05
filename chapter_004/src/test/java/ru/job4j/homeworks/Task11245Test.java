package ru.job4j.homeworks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11245Test {
    private Task11245 test = new Task11245();

    @Test
    public void whenAskToReplaceArrayFirstSubzeroThenUpzeroThenReturnIt() {
        assertThat(test.minusAndPlus(new int[]{3, 1, -1, -3}), is(new int[]{-1, -3, 1, 3}));
    }

    @Test
    public void whemAskToReplaceArrayFirstSubzeroThenUpzeroThenReturnItArrayListWay() {
        assertThat(test.minusAndPlus(new ArrayList<Integer>(Arrays.asList(3, 1, -1, -3))), is(new ArrayList<Integer>(Arrays.asList(-1, -3, 1, 3))));
    }
}
