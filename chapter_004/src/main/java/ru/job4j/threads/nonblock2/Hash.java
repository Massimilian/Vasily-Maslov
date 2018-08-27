package ru.job4j.threads.nonblock2;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hash {
    ConcurrentHashMap<Integer, Integer> map;
    Lock l = new ReentrantLock();

    public void add(Base model) {
        l.lock();
        map.put(model.id, model.version);
        l.unlock();
    }

    public void update(Base model) {

    }

    public void delete(Base model) {
        l.lock();
        map.remove(model.id);
        l.unlock();
    }
}
