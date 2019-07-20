package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collection.dinamics.DinamicBase;
import ru.job4j.collection.dinamics.Type;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DinamicIntegerListTest {
    public DinamicBase<Integer> list = new DinamicThreadSafeList(Type.Integer);

    @Test
    public void whenTryToPutNewValueAndTryHowIteratorWorksThenDoItWell() {
        list.add(1);
        list.add(2, 2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        list.add(4);
        int checking = 0;
        list.add(5);
        while (iterator.hasNext() && iterator.next() != null) {
            checking++;
        }
        for (int i = 0; i < 15; i++) {
            list.add(i + 6);
        }
        list.deleteNulls();
        iterator = list.iterator();
        int checkingTwo = 0;
        while (iterator.hasNext()) {
            iterator.next();
            checkingTwo++;
        }
        assertThat(checking, is(3));
        assertThat(checkingTwo, is(20));
    }
}
