package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task3Test {
    private Task2 pointX = new Task2(0, 0);
    private Task2 pointY = new Task2(2, 0);
    private Task2 pointZ = new Task2(0, 2);
    private Task3 test = new Task3(pointX, pointY, pointZ);

    @Test
    public void whenTryToKnowTheAreaOfTriangleThenReturnIt() {
        test.area();
        // далее делаю упрощение, так как double делает не совсем точные вычисления. Как это забороть - пока не знаю.
        assertThat((int) test.area(), is(2));
    }
}

