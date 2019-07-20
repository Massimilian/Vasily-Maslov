package ru.job4j.collection;

import net.jcip.annotations.ThreadSafe;
import ru.job4j.collection.dinamics.*;

import java.util.Arrays;
import java.util.Iterator;

/**
 * A thread-safe modification of DinamicBase with all old methods, made as thread-safe (by based dinamicBase list).
 *
 * @param <E> may be byte, double, float, int, long, boolean or String.
 */
@ThreadSafe
public class DinamicThreadSafeList<E> implements DinamicBase<E> {
    private final DinamicBase list;
    private E[] temp;

    public DinamicThreadSafeList(Type type) {
        switch (type) {
            case Boolean:
                list = new DinamicBooleanList();
                break;
            case Byte:
                list = new DinamicByteClass();
                break;
            case Double:
                list = new DinamicDoubleClass();
                break;
            case Float:
                list = new DinamicFloatList();
                break;
            case Integer:
                list = new DinamicIntegerList();
                break;
            case Long:
                list = new DinamicLongClass();
                break;
            case String:
                list = new DinamicStringList();
                break;
            default:
                System.out.println("ERROR");
                list = null;
        }
    }

    @Override
    public void add(E e) {
        synchronized (this.list) {
            this.list.add(e);
        }
    }

    @Override
    public void add(E e, int num) {
        synchronized (this.list) {
            this.list.add(e, num);
        }

    }

    @Override
    public void deleteByValue(E e) {
        synchronized (this.list) {
            this.list.deleteByValue(e);
        }
    }

    @Override
    public void deleteByPosition(int pos) {
        synchronized (this.list) {
            this.list.deleteByPosition(pos);
        }
    }

    @Override
    public void deleteNulls() {
        synchronized (this.list) {
            this.list.deleteNulls();
        }
    }

    @Override
    public Iterator iterator() {
        synchronized (this.list) {
            this.temp = this.getArray();
            return Arrays.asList(temp).iterator();
        }
    }

    @Override
    public E[] getArray() {
        return (E[]) Arrays.copyOf(this.list.getArray(), this.list.getArray().length);
    }
}
