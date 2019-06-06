package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public class Softs {
private HashMap<Integer, SoftReference<String>> map = new HashMap<Integer, SoftReference<String>>();

    public void putSoft(int key, String string) {
        map.put(key, new SoftReference<String>(string));
    }

    public HashMap<Integer, SoftReference<String>> getMap() {
        return map;
    }
}
