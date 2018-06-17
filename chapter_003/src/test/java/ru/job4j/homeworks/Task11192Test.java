package ru.job4j.homeworks;

import org.junit.Test;
import java.util.Random;
import java.util.TreeMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11192Test {
    Task11192 test = new Task11192();
    TreeMap<Integer, int[]> map = new TreeMap<>();
    Random random = new Random();

    @Test
    public void whenTryToFindAllEqualsTheReturnThemInTreeMapFormat() {
        TreeMap<Integer, int[]> result = test.findEquals(new char[]{'0', '1', '2', '2', 'п', 'ы', 'q', ']', 'ъ', 'Ъ', 'ы', 'ы', 'Ъ'});
        assertThat(result.get(1), is(new int[]{3, 4}));
        assertThat(result.get(2), is(new int[]{6, 11}));
        assertThat(result.get(3), is(new int[]{10, 13}));
    }
}
