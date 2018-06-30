package ru.job4j.departments;


import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DepartmentsTest {
    private Department department1 = new Department("K1\\SK1");
    private Department department2 = new Department("K2\\SK1\\SSK2");
    private Department department3 = new Department("K2");
    private Department department4 = new Department("K1\\SK1\\SSK1");
    private Department department5 = new Department("K2\\SK1\\SSK3");
    private Department department6 = new Department("K1\\SK1\\SSK2");
    private Department department7 = new Department("K1\\SK2");
    private Department department8 = new Department("K3\\SK1");
    private Departments allDeps = new Departments(new ArrayList<Department>(Arrays.asList(department1, department2, department3, department4, department5, department6, department7, department8)));

    @Test
    public void whenAskSortingByRangeThenReturnIt() {
        allDeps.sorting();
        assertThat(allDeps.getDeps().get(0).getName(), is("K1"));
        assertThat(allDeps.getDeps().get(1).getName(), is("K1\\SK1"));
        assertThat(allDeps.getDeps().get(2).getName(), is("K1\\SK1\\SSK1"));
        assertThat(allDeps.getDeps().get(3).getName(), is("K1\\SK1\\SSK2"));
        assertThat(allDeps.getDeps().get(4).getName(), is("K1\\SK2"));
        assertThat(allDeps.getDeps().get(5).getName(), is("K2"));
        assertThat(allDeps.getDeps().get(6).getName(), is("K2\\SK1\\SSK2"));
        assertThat(allDeps.getDeps().get(7).getName(), is("K2\\SK1\\SSK3"));
        assertThat(allDeps.getDeps().get(8).getName(), is("K3"));
        assertThat(allDeps.getDeps().get(9).getName(), is("K3\\SK1"));
    }

    @Test
    public void whenAskSortingByBackRangeThenReturnIt() {
        allDeps.backSorting();
        assertThat(allDeps.getDeps().get(0).getName(), is("K3"));
        assertThat(allDeps.getDeps().get(1).getName(), is("K3\\SK1"));
        assertThat(allDeps.getDeps().get(2).getName(), is("K2"));
        assertThat(allDeps.getDeps().get(3).getName(), is("K2\\SK1\\SSK3"));
        assertThat(allDeps.getDeps().get(4).getName(), is("K2\\SK1\\SSK2"));
        assertThat(allDeps.getDeps().get(5).getName(), is("K1"));
        assertThat(allDeps.getDeps().get(6).getName(), is("K1\\SK2"));
        assertThat(allDeps.getDeps().get(7).getName(), is("K1\\SK1\\SSK2"));
        assertThat(allDeps.getDeps().get(8).getName(), is("K1\\SK1\\SSK1"));
        assertThat(allDeps.getDeps().get(9).getName(), is("K1\\SK1"));
    }
}
