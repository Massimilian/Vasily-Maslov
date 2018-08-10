package ru.job4j.threads.nonblock;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class Hash {
    ConcurrentHashMap<Integer, Base> chm = new ConcurrentHashMap<>();

    public void add(Base model) {
        chm.put(model.getId(), model);
    }

    public void update(Base model) {
        model.setVersion(model.getVersion() + 1);
        if (chm.contains(model)) {
            throw new OptimisticException();
        } else {
            this.add(model);
        }
    }

    public void delete(Base model) {
        chm.remove(model.getId());
    }
}
