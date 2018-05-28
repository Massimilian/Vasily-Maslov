package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11109Test {

    @Test
    public void whenAskTheBiggestPriceThenReturnIt() {
        Task11109 test = new Task11109();
        assertThat(test.biggestPrice(new int[]{3234, 3234, 5456, 4342, 1454, 3562, 6543, 15556, 34234, 3245}), is(34234));
    }
}
