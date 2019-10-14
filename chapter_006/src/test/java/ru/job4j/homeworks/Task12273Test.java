package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12273Test {
    Task12273 test = new Task12273();
    String text = "Это чётная строка!";
    String textTwo = "Тут строка другая.";
    char[][] forPrepare = {{'Э', 'Т', 'т', 'у', 'о', 'т'}, {' ', ' ', 'ч', 'с', 'ё', 'т'}, {'т', 'р', 'н', 'о', 'а', 'к'}, {'я', 'а', ' ', ' ', 'с', 'д'}, {'т', 'р', 'р', 'у', 'о', 'г'}, {'к', 'а', 'а', 'я', '!', '.'}};

    @Test
    public void whenTryToPrepareTwoStringsThenDoIt() {
        assertThat(test.takeEven(forPrepare, true), is(text));
        assertThat(test.takeEven(forPrepare, false), is(textTwo));

    }
}
