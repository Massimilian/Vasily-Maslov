package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12277Test {
    Task12277 test = new Task12277();
    char a = 'д';
    char z = 'а';
    char[][] is = {{'д', 'а', ','}, {'e'}, {'1', '4', '=', 'а'}, {}, {'а', ';', '\\', 'д', '#'}};
    char[][] no = {{'4', '3', '5'}, {'а', 'у', 'д'}, {'а'}};

    @Test
    public void whenHasLetterAfterLetterReturnTrueIfNoReturnFalse() {
        assertThat(test.check(is, a, z), is(true));
        assertThat(test.check(no, a, z), is(false));

    }
}
