package ru.job4j.homeworks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Task1348Test {
    private ArrayList<String> names = (ArrayList<String>) Stream.of("Ivanov", "Petrov", "Sidorov").collect(Collectors.toList());
    private Task1348 test = new Task1348(names);
    private TreeMap<String, Integer> mathMarks = new TreeMap<>();
    private TreeMap<String, Integer> mathUpMarks = new TreeMap<>();
    private TreeMap<String, Integer> engMarks = new TreeMap<>();
    private TreeMap<String, Integer> histMarks = new TreeMap<>();

    @Test
    public void whenTryToMakeNewAdditionThenDoIt() {
        mathMarks.put(names.get(0), 5);
        mathMarks.put(names.get(1), 4);
        mathUpMarks.put(names.get(2), 3);
        engMarks.put(names.get(0), 3);
        engMarks.put(names.get(1), 4);
        engMarks.put(names.get(2), 5);
        histMarks.put(names.get(0), 5);
        histMarks.put(names.get(1), 5);
        histMarks.put(names.get(2), 5);
        test.addMarks("Mathematics", mathMarks, 1);
        test.addMarks("Mathematics", mathUpMarks);
        test.addMarks("English", engMarks, 1);
        test.addMarks("History", histMarks, 1);
        test.addNewPupil("Krasnov");
        test.deletePupil("Krasnov");
        ArrayList<String> ivanovMarks = test.takeMarks("Ivanov");
        ArrayList<String> petrovMarks = test.takeMarks("Petrov");
        ArrayList<String> sidorovMarks = test.takeMarks("Sidorov");
        assertThat(ivanovMarks.get(0), is("5"));
        assertThat(ivanovMarks.get(1), is("5"));
        assertThat(ivanovMarks.get(2), is("3"));
        assertThat(petrovMarks.get(0), is("5"));
        assertThat(petrovMarks.get(1), is("4"));
        assertThat(petrovMarks.get(2), is("4"));
        assertThat(sidorovMarks.get(0), is("5"));
        assertThat(sidorovMarks.get(1), is("3"));
        assertThat(sidorovMarks.get(2), is("5"));
        test.deleteAll();
    }
}
