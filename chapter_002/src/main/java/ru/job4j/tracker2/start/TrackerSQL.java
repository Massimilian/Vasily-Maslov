package ru.job4j.tracker2.start;

import ru.job4j.tracker2.models.Item;
import java.util.ArrayList;

public class TrackerSQL implements ITracker, AutoCloseable {
    @Override
    public void add(Item item) {

    }

    @Override
    public void replace(String id, Item item) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Item[] findAll() {
        return new Item[0];
    }

    @Override
    public ArrayList<Item> findByName(String key) {
        return new ArrayList<Item>();
    }

    @Override
    public Item findById(String id) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
