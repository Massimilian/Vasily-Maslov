package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task119Test {
    Task119 test = new Task119();

    @Test
    public void whenAskArithmeticArrayThenReturnIt() {
        assertThat(test.arithmeticProgress(1, 2), is(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19}));
    }

    @Test
    public void whenAskGeometricArrayThenReturnIt() {
        assertThat(test.geometricProgress(1, 2), is(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288}));
    }

    @Test
    public void whenAskEasyFibonachiArrayThenReturnIt() {
        assertThat(test.easyFibonachiPrigress(), is(new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144}));
    }

    @Test
    public void whenAskFibonachiArrayThenReturnIt() {
        assertThat(test.fibonachiProgress(), is(new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144}));
    }
}