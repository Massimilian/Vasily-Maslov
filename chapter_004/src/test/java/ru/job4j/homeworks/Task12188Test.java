package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12188Test {
    private Task12188 test = new Task12188();
    private int[][] evenArray = {{1, 2, 3, 4}, {5, 6, 7, 8}, {8, 7, 6, 5}, {4, 3, 2, 1}};
    private int[][] wrongEvenArray = {{1, 2}, {3, 4}};
    private int[][] notEvenArray = {{1, 2, 0}, {4, 3, 4}, {0, 2, 1}};
    private int[][] wrongNotEvenArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    @Test
    public void whenTryToCheckArrayThenReturnInfoAboutItsSimmetrial() {
        assertThat(test.isSimm(evenArray), is(true));
        assertThat(test.isSimm(wrongEvenArray), is(false));
        assertThat(test.isSimm(notEvenArray), is(true));
        assertThat(test.isSimm(wrongNotEvenArray), is(false));
    }
}
