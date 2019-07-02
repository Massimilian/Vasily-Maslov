package ru.job4j.lambda.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LevelOfTest {
    private Student n = null;
    private List<Student> students = new ArrayList<Student>(Arrays.asList(new Student("Three", 3), new Student("Five", 5), new Student("Two", 2), new Student("Four", 4), new Student("One", 1), n));
    private LevelOf test = new LevelOf();

    @Test
    public void whenTryToTestMethodOfSortingAndDeletingThenDoIt() {
        List<Student> result = test.levelOf(students, 0);
        assertThat(result.size(), is(5));
        result = test.levelOf(students, 3);
        assertThat(result.size(), is(3));
        result = test.levelOf(students, 5);
        assertThat(result.size(), is(1));
        result = test.levelOf(students, 6);
        assertThat(result.isEmpty(), is(true));
    }
}
