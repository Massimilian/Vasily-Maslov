package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12278Test {
    Task12278 test = new Task12278();
    char[][] chars = {{'o', '\'', '\\', 's', '\\', '\\'}, {'o', 'o', 'o'}, {'o', '\\', 'o', 'o', '\\', '\'', '\\', 'f', 'g'}, {'\\', '\\', '\\', '\\'}, {}, {'o', 'o'}};
    char one = 'o';
    char two = '\\';

    @Test
    public void whenTryToFindTheConcretNumberOfConcretSymbolsThenDoIt() {
        assertThat(test.find(chars, two, 4), is(1));
        assertThat(test.find(chars, one, 3), is(2));
        assertThat(test.find(chars, two, 1), is(0));
    }
}