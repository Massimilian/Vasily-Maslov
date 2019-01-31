package ru.job4j.tracker2.start.interfaces;

public interface ITrackerSQL extends ITracker {
    void findByNameSQL(String key);

    void findByIdSQL(String id);

    void getAllwithSQL();

    void activate();
}
