package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TestMapTest {
    private TestMap<String, String> tm = new TestMap<>();

    @Test
    public void whenInsertNewValueThenPutItIn() {
        tm.insert("1", "111");
        assertThat(tm.get("1"), is("111"));
    }

    @Test
    public void whenInsertThenDeleteNewValueThenDeleteItFromMap() {
        tm.insert("1", "111");
        tm.insert("2", "222");
        tm.insert("something", "something");
        assertThat(tm.insert("1", "111"), is(false));
        assertThat(tm.getSize(), is(3));
        tm.delete("1");
        assertThat(tm.getSize(), is(2));
        tm.delete("2");
        assertThat(tm.getSize(), is(1));
        assertThat(tm.get("something"), is("something"));
    }

    @Test
    public void whenAddManyPointsThenCheckThatTheArrayNowIsBiggerThenInPast() {
        tm.insert("1", "111");
        tm.insert("2", "222");
        tm.insert("3", "333");
        tm.insert("4", "444");
        tm.insert("5", "555");
        tm.insert("6", "666");
        tm.insert("7", "777");
        assertThat(tm.getSize(), is(7));
    }

    @Test
    public void whenTryToTestIteratorThenReturnAllRight() {
        tm.insert("1", "111");
        tm.insert("2", "222");
        tm.insert("3", "333");
        Iterator<String> iterator = tm.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("111"));
        assertThat(iterator.next(), is("222"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("333"));
        assertThat(iterator.hasNext(), is(false));

    }
}
