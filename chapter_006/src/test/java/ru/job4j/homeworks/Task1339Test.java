package ru.job4j.homeworks;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Task1339Test {
    private Task1339 test = new Task1339();
    private ArrayList<Pupil138> list = new ArrayList<>();

    @Test
    public void whenTryToFindTheTallestThenDoIt() {
        list.add(new Pupil138("Petrov", 132));
        list.add(new Pupil138("Sidorov", 123));
        list.add(new Pupil138("Ivanov", 143));

        assertThat(test.tallestSurname(list), is("Ivanov"));
        assertThat(test.twoSemitallestSurnames(list, 1, 2), is(new String[]{"Petrov", "Sidorov"}));
    }
}
