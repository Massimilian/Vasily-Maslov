package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1280Test {
    private Task1280 test = new Task1280();
    int[][] array = {{1, 2, 3, 4, 3, 5, 7}, {6, 3, 4, 3}, {0, 8, 9, 7, 8, 6, 4}, {}, {1, 4, 5, 4, 2, 2, 0, 9, 2}, {7, 6, 0, 9, 2, 3, 4, 6, 5, 7}};

    @Test
    public void whenAskHowMuchDifferentsWithoutCollectionsTheReturnResult() {
        assertThat(test.howMuchDifferentsWithoutCollections(array), is(10));
    }
}
