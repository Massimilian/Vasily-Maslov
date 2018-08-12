package ru.job4j.threads.nonblock;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class Hash {
    private ConcurrentHashMap<Integer, Base> chm = new ConcurrentHashMap<>();

    public void add(Base model) {
        chm.put(model.getId(), model);
    }

    public void update(Base model) {
        Base temp = null;
        // ищем нужную модель для обновления
        for (Map.Entry<Integer, Base> base : chm.entrySet()) {
            if (base.getKey() == model.getId() && base.getValue().getVersion() == model.getVersion()) {
                temp = model;
                temp.setVersion(model.getVersion() + 1);
                break;
            }
        }
        // если модели нет или она уже обновлена - кидаем исключение
        if (temp == null) {
            throw new OptimisticException();
        }
        this.delete(model);
        this.add(temp);
    }

    public void delete(Base model) {
        chm.remove(model.getId());
    }

    public ConcurrentHashMap<Integer, Base> getChm() {
        return chm;
    }
}
