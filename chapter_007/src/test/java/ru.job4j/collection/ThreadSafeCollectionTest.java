package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ThreadSafeCollectionTest {
    private ThreadSafeCollection<Integer> threadSafeCollection = new ThreadSafeCollection<Integer>();
    private List<Integer> toAdd = List.of(6, 7, 8);
    private List<Integer> toDelete = List.of(2, 4, 6, 1);

    @Test
    public void whenTryToTakeSynchronizedIteratorThenDoIt() {
        threadSafeCollection.add(1);
        threadSafeCollection.add(0, 2);
        threadSafeCollection.add(3);
        Iterator<Object> iterator = threadSafeCollection.iterator();
        threadSafeCollection.add(4);
        int checking = 0;
        threadSafeCollection.add(5);
        threadSafeCollection.addAll(toAdd);
        threadSafeCollection.removeAll(toDelete);
        while (iterator.hasNext()) {
            iterator.next();
            checking++;
        }
        assertThat(checking, is(3));
        assertThat(threadSafeCollection.size(), is(4));
    }
}
