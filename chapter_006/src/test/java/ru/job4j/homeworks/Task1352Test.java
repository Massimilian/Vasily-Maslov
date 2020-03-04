package ru.job4j.homeworks;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Task1352Test {
    Task1352 test = new Task1352();
    Map<String, Integer> map = new HashMap<>();

    @Test
    public void whenTryToSortPupilsBySizeThenDoIt() {
        map.put("Ivanov", 134);
        map.put("Sidorov", 110);
        map.put("Petrov", 112);
        assertThat(test.getNames(map).get(0), is("Ivanov"));
        assertThat(test.getNames(map).get(1), is("Petrov"));
        assertThat(test.getNames(map).get(2), is("Sidorov"));
    }
}
