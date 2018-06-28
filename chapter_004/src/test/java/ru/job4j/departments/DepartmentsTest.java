package ru.job4j.departments;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DepartmentsTest {
    Department dep1 = new Department("H1\\1");
    Department dep2 = new Department("H1\\2");
    Department dep3 = new Department("H1\\3");
    Department dep4 = new Department("H1\\4");
    Departments deps = new Departments(Arrays.asList(dep1, dep2, dep3, dep4));

}
