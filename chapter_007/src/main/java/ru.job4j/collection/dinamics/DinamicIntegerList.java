package ru.job4j.collection.dinamics;

/**
 * Integer realization of DinamicList
 */

public class DinamicIntegerList extends DinamicBaseList<Integer> {
    @Override
    public Class<Integer> getClassDef() {
        return Integer.class;
    }
}
