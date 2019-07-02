package ru.job4j.lambda.stream;

import java.util.Comparator;

public class Student {
    private String name;
    private int scope;

    public int getScope() {
        return scope;
    }

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }
}
