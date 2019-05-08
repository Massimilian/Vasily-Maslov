package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.util.HashMap;

public class Softs {
    private HashMap<Integer, SoftReference<Object>> map = new HashMap<>();

    public Object get(Integer key) {
        Object result = null;
        if (map.containsKey(key)) {
            result = map.get(key);
            return result;
        } else {
            System.out.println("The reference is not working.");
            return result;
        }
    }

    public void put(Integer key, Object object) {
        map.put(key, new SoftReference<Object>(object));
    }
}
