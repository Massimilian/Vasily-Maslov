package ru.job4j.tracker2.start;

import ru.job4j.tracker2.models.Item;

import java.util.ArrayList;

public interface ITracker {
    void add(Item item);
    void replace(String id, Item item);
    void delete(String id);
    Item[] findAll();
    ArrayList<Item> findByName(String key);
    Item findById(String id);
}
