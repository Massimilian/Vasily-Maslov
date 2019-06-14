package ru.job4j.lambda.filtration;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class SchoolTest {
    private School school = new School();
    private List<Student> students = new ArrayList<>();
    private int down = 50;
    private int middle = 70;
    private int high = 100;

    @Test
    public void whenTryToSortAllStudentsThenDoIt() {
        this.fillList(students);
        assertThat(school.collect(students, x -> x.getScore() < down).size(), is(50));
        assertThat(school.collect(students, x -> x.getScore() >= down && x.getScore() < middle).size(), is(20));
        assertThat(school.collect(students, x -> x.getScore() > middle).size(), is(30));
    }

    private List<Student> fillList(List<Student> list) {
        for (int i = 0; i <= high; i++) {
            list.add(new Student(i));
        }
        return list;
    }
}
