package ru.job4j.collection.dinamics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * This abstract class is the base for working with dinamic array with any type (you may choose your type in constructor).
 *
 * @param <E> realized as byte, double, float, int, long, boolean and String.
 */
public abstract class DinamicBaseList<E> implements DinamicBase<E> {

    private int count = 0;
    private int length = 10;
    private E[] array = (E[]) java.lang.reflect.Array.newInstance(getClassDef(), length);

    /**
     * Method to take the array for work
     *
     * @return working array
     */
    @Override
    public E[] getArray() {
        return array;
    }

    /**
     * This method must be realized in any class that want to have dinamic array of something
     *
     * @return type of arguments (class)
     */
    public abstract Class<E> getClassDef();

    /**
     * Adding new value
     *
     * @param e to add
     */
    public void add(E e) {
        while (array[count] != null) {
            this.count++;
            reNew();
        }
        array[count++] = e;
        reNew();
    }

    /**
     * adding new value on concrete position
     *
     * @param e   to add
     * @param num is position
     */
    public void add(E e, int num) {
        if (num >= length - 1) {
            this.length = num + 1;
            reNewPlus(length);
        }
        array[num] = e;
        this.count = 0;
    }

    /**
     * Delete value "by value"
     *
     * @param e value for delete
     */
    public void deleteByValue(E e) {
        for (int i = 0; i < length; i++) {
            if (this.array[i] == e) {
                this.array[i] = null;
                break;
            }
        }
    }

    /**
     * Delete value by position
     *
     * @param pos position
     */
    public void deleteByPosition(int pos) {
        array[pos] = null;
    }

    /**
     * Delete all null cells
     */
    public void deleteNulls() {
        this.array = (E[]) Arrays.stream(array).flatMap(Stream::ofNullable).toArray();
    }

    /**
     * getting iterator
     *
     * @return iterator of base array
     */
    public Iterator<E> iterator() {
        return Arrays.asList(array).iterator();
    }

    /**
     * method of checking of necessity of new array, more big.
     */
    private void reNew() {
        if (this.count >= this.length - 1) {
            this.length *= 1.5D;
            reNewPlus(length);
        }
    }

    /**
     * Getting more big array
     *
     * @param length is new length
     */
    private void reNewPlus(int length) {
        this.array = Arrays.copyOf(array, length);
    }
}
