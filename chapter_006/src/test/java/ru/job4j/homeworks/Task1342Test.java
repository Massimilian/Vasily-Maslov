package ru.job4j.homeworks;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1342Test {
    private Task1342 test = new Task1342();
    private Train1342 one = new Train1342(1, new Time1342(1, 10), new Time1342(1, 30));
    private Train1342 two = new Train1342(2, new Time1342(1, 25), new Time1342(1, 40));
    private Train1342 three = new Train1342(3, new Time1342(1, 35), new Time1342(1, 40));
    private Train1342 four = new Train1342(4, new Time1342(1, 10), new Time1342(1, 40));
    private Time1342 time = new Time1342(1, 28);
    private ArrayList<Train1342> trains = new ArrayList<Train1342>();

    @Test
    public void whenTryToCheckTrainsThenDoIt() {
        trains.add(one);
        trains.add(two);
        trains.add(three);
        trains.add(four);
        assertThat(test.getTrains(trains, time).get(0).getNumber(), is(1));
        assertThat(test.getTrains(trains, time).get(1).getNumber(), is(2));
        assertThat(test.getTrains(trains, time).get(2).getNumber(), is(4));
    }
}
