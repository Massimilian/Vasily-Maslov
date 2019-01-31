package ru.job4j.tracker2.start.interfaces;

import ru.job4j.tracker2.models.Item;

import java.util.ArrayList;
import java.util.List;

public interface ITrackerStandart extends ITracker {
    ArrayList<Item> findByName(String key);

    Item findById(String id);

    List<Item> getAll();

    String generateId();
}
