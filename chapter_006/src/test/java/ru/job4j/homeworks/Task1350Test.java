package ru.job4j.homeworks;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Task1350Test {
    Task1350 test = new Task1350();
    TreeMap<String, Integer> comm = new TreeMap();

    @Test
    public void whenTryToPutNewCommandThenDoIt() {
        comm.put("First", 100);
        comm.put("Third", 10);
        test.insert(comm, "Second", 50);
        assertThat(comm.size(), is(3));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : comm.entrySet()) {
            sb.append(entry.getKey());
        }
        String result = sb.toString();
        assertThat(result, is("FirstSecondThird"));
    }
}
