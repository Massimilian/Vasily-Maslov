package ru.job4j.homeworks;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Task133Test {
    Task133 test = new Task133();
    HashMap<String, String> entries = new HashMap<>();

    @Test
    public void whenTryToFindAllItalyTownsFromTheMapThenDoIt() {
        entries.put("Рим", "Италия");
        entries.put("Вашингтон", "США");
        entries.put("Верона", "Италия");
        entries.put("Токио", "Япония");
        entries.put("Нагасаки", "Япония");
        entries.put("Никольск", "Россия");
        assertThat(test.findTowns("Италия", entries).size(), is(2));
    }
}
