package ru.job4j.homeworks;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1314Test {
    private Task1314 test = new Task1314();
    private ArrayList<Moment1314> times = new ArrayList<>();

    @Test
    public void whenTryToChangeTheMoreEarlierTimeThenDoIt() {
        times.add(new Moment1314(12, 30));
        times.add(new Moment1314(12, 45));
        times.add(new Moment1314(13, 20));
        times.add(new Moment1314(13, 0));
        times.add(new Moment1314(12, 59));
        assertThat(test.earlier(times, 1, 2).getHour(), is(12));
        assertThat(test.earlier(times, 1, 2).getMinute(), is(45));
        assertThat(test.earlier(times, 4, 1).getHour(), is(12));
        assertThat(test.earlier(times, 4, 1).getMinute(), is(45));
    }
}
