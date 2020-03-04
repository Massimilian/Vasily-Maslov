package ru.job4j.homeworks;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Task1351Test {
    Task1351 test = new Task1351();
    Map<String, Integer> map = new HashMap<>();

    @Test
    public void whenTryToTakeACommandByPositionThenDoIt() {
        map.put("First", 100);
        map.put("Third", 80);
        map.put("Second", 90);
        assertThat(test.commandName(map, 1), is("First"));
        assertThat(test.commandName(map, 2), is("Second"));
        assertThat(test.commandName(map, 3), is("Third"));
        assertThat(test.commandName(map, 4), is("There's no any command."));
    }
}
