package ru.job4j.homeworks;

import jdk.nashorn.api.tree.ArrayLiteralTree;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task131Test {
    Task131 test = new Task131();
    ArrayList<String> a = new ArrayList<String>();
    ArrayList<String> b = new ArrayList<String>();

    @Test
    public void whenTryToComplicateTwoListsThenDoIt() {
        a.add("Sidorov");
        a.add("Ivanov");
        a.add("Petrov");
        b.add("Sidor");
        b.add("Ivan");
        test.print(a, b);
    }
}
