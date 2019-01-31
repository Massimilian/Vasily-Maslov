package ru.job4j.tracker2.start;

import ru.job4j.tracker2.models.*;
import ru.job4j.tracker2.start.interfaces.ITrackerStandart;

import java.sql.*;
import java.util.*;

public class Tracker implements ITrackerStandart, AutoCloseable {
    private List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();
    private Connection connection;

    public Item getItem(int position) {
        return items.get(position);
    }

    public void add(Item item) {
        item.setId(this.generateId());
        items.add(item);
    }

    @Override
    public void replace(String id, Item item) {

    }

    @Override
    public boolean update(Item fresh) {
        boolean isDone = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i) != null && this.items.get(i).getId().equals(fresh.getId())) {
                items.remove(i);
                items.add(i, fresh);
                isDone = true;
                break;
            }
        }
        return isDone;
    }


    public void delete(String id) {
        for (int i = 0; i < this.items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                break;
            }
        }
    }

    @Override
    public Item[] findAll() {
        return new Item[0];
    }


    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    @Override
    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    @Override
    public List<Item> getAll() {
        return items;
    }

    @Override
    public void close() throws Exception {
    }
}