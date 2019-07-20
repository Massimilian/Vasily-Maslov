package ru.job4j.collection.dinamics;

import java.util.Iterator;

/**
 * Basic Interface for array with dinamic length and posibility of work with every types of arguments
 *
 * @param <E> realized as byte, double, float, int, long, boolean and String.
 */
public interface DinamicBase<E> {
    void add(E e);

    void add(E e, int num);

    void deleteByValue(E e);

    void deleteByPosition(int pos);

    void deleteNulls();

    Iterator<E> iterator();

    E[] getArray();
}
