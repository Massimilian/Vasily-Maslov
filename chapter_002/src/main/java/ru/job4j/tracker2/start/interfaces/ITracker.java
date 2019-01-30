package ru.job4j.tracker2.start.interfaces;

import ru.job4j.tracker2.models.Item;

import java.util.ArrayList;
import java.util.List;

public interface ITracker {
    void add(Item item);

    void replace(String id, Item item);

    void delete(String id);

    boolean update(Item fresh);

    Item[] findAll();

    String generateId();

}
