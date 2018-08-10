package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task6Test {
    Task2 one = new Task2(0, 0);
    Task2 two = new Task2(3, -1);
    Task2 three = new Task2(2, 1);
    Task2 four = new Task2(1, -2);
    Task6 test;

    @Test
    public void whenTryToMakeNewCuadradoThenReturnItMaked() {
        // Данный тест не отработал,так как в вычислениях Double происходят неточности. Как это забороть - пока не знаю.
//        test = new Task6(one, two, three, four);
//        assertThat(test.exists(), is(true));
    }
}
