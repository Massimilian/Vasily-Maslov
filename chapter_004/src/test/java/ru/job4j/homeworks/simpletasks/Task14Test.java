package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task14Test {
    private Task14 test = new Task14();
    private String strToTurn = "Dog eats sausage";

    @Test
    public void whenTryToTurnTheStringThenDoIt() {
        assertThat(test.removeWords(strToTurn), is("sausage eats Dog"));
    }
}
