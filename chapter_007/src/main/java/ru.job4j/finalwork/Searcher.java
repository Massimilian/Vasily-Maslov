package ru.job4j.finalwork;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Searcher {
    private final ArrayList<String> pool;

    public Searcher(ArrayList<String> pool) {
        this.pool = pool;
    }

    /**
     * Method for searching all Strings with condition
     *
     * @param condition for find
     * @return result of searching (CopyOnWriteArrayList)
     */
    public CopyOnWriteArrayList<String> search(String condition) {
        CopyOnWriteArrayList<String> result = new CopyOnWriteArrayList<>();
        LinkedList<String>[] prepared = prepare(Runtime.getRuntime().availableProcessors());
        ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        int count = Math.min(Runtime.getRuntime().availableProcessors(), pool.size());
        for (int i = 0; i < count; i++) {
            exec.execute(new SearchThread(result, prepared[i], condition));
        }
        exec.shutdown();
        return result;
    }

    /**
     * Organizer for prepare the List to threads
     *
     * @param count
     * @return
     */
    private LinkedList<String>[] prepare(int count) {
        LinkedList<String>[] prepared = divider(Runtime.getRuntime().availableProcessors());
        return fill(prepared);
    }

    /**
     * Method to prepare empty array of lists
     *
     * @param count is number of cells
     * @return prepared List
     */
    private LinkedList<String>[] divider(int count) {
        LinkedList<String>[] result = new LinkedList[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = new LinkedList<String>();
        }
        return result;
    }

    /**
     * Method for fill the List with values of strings of pool
     *
     * @param forFill is an array for fill
     * @return filled array
     */
    private LinkedList<String>[] fill(LinkedList<String>[] forFill) {
        int count = 0;
        for (int i = 0; i < pool.size(); i++) {
            forFill[count++].add(pool.get(i));
            count = count == forFill.length ? 0 : count;
        }
        return forFill;
    }
}
