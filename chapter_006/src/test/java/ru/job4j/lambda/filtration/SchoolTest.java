package ru.job4j.lambda.filtration;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SchoolTest {
    private School school = new School();
    private List<Student> students = new ArrayList<>();
    private String[] names = {"A", "B", "C", "D", "!", "~"};
    private Student student = new Student(100, "Z");
    private Map<String, Student> result;
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

    @Test
    public void whenTryToPutStudentsListIntoMapVersionThenDoIt() {
        this.fillList(students, names);
        students.add(student);
        result = school.reformat(students);
        assertThat(result.get("Z"), is(student));
    }

    private List<Student> fillList(List<Student> list) {
        for (int i = 0; i <= high; i++) {
            list.add(new Student(i));
        }
        return list;
    }

    private List<Student> fillList(List<Student> list, String[] names) {
        for (int i = 0; i < names.length; i++) {
            list.add(new Student(i, names[i]));
        }
        return list;
    }
}
