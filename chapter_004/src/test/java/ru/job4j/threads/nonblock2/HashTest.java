package ru.job4j.threads.nonblock2;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class HashTest {
    @Test
    public void whenTryToDoThenDoIt() {
        Map<String, Integer> wordCounts = new LinkedHashMap<String, Integer>();

        String s = "asd asd asdf asd as";
        wordCounts.put("asd", 0);
        wordCounts.put("erat", 0);

        for (String t : s.split(" ")) {
            wordCounts.computeIfPresent(t, (k, v) -> v + 1);
        }
        System.out.println(wordCounts);
    }
}
