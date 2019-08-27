package ru.job4j.servtests;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Singletone {
    public static Singletone instance;
    List<Person> names = new CopyOnWriteArrayList<Person>();

    public static Singletone getInstance() {
        if (instance == null) {
            instance = new Singletone();
        }
        return instance;
    }

    private Singletone() {
    }

    public List<Person> getNames() {
        return instance.names;
    }

}
