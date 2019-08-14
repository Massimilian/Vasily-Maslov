package ru.job4j.finalwork;

import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class SearchThread implements Runnable {
    private final CopyOnWriteArrayList<String> result;
    private final LinkedList<String> prepared;
    private final String condition;

    public SearchThread(CopyOnWriteArrayList<String> result, LinkedList<String> prepared, String condition) {
        this.result = result;
        this.prepared = prepared;
        this.condition = ".*" + condition + ".*";
    }

    /**
     * Checking the cells, if matches - for add.
     */
    @Override
    public void run() {
        for (int i = 0; i < prepared.size(); i++) {
            if (prepared.get(i).matches(condition)) {
                result.add(prepared.get(i));
            }
        }
    }
}
