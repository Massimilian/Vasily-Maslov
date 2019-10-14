package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12275Test {
    Task12275 test = new Task12275();
    char[][] arr = {{'d', 'c', 'f', 'u'}, {'c', 'c', 'f', 'd', 'a'}, {'a', 'f', 'd'}, {'f', 'd', 'c', 'f', 'g', 'f'}};
    char one = 'd';
    char two = 'f';
    int[] result = {1, 0, 0, 2};

    @Test
    public void whenTryToFindTheLetterAfterAnotherLetterThenDoIt() {
        assertThat(test.find(arr, one, two), is(result));
    }
}
