package ru.job4j.collection.dinamics;

/**
 * String realization of DinamicList
 */

public class DinamicStringList extends DinamicBaseList {
    @Override
    public Class getClassDef() {
        return String.class;
    }
}
