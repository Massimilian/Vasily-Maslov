package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task8Test {
    private Task8 test = new Task8();
    private LinkedList<Integer> numbers = new LinkedList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));

    @Test
    public void whenAskSimpleNumbersBeforeNumberThenReturnThem() {
        assertThat(test.simpleNumbers(21), is(numbers));
    }
}
