package ru.job4j.homeworks;

import org.junit.Test;

import java.util.ArrayList;

public class Task138Test {
    Task138 test = new Task138();
    ArrayList<Pupil138> pupils = new ArrayList<>();

    @Test
    public void whenNeedTiShowNumbersWithoutNumbers() {
        pupils.add(new Pupil138("Name", "Surname", "action"));
        pupils.add(new Pupil138("Name", "Surname", "action", 4264164));
        test.withoutPhones(pupils);
    }
}
