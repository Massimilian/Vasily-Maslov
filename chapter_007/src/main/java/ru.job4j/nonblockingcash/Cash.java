package ru.job4j.nonblockingcash;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Special class to keep the cash in non-blocking algorithm
 */
public class Cash {
    private ConcurrentHashMap<Integer, Base> storage = new ConcurrentHashMap<>();

    protected ConcurrentHashMap<Integer, Base> getStorage() {
        return storage;
    }

    /**
     * Method to add new value
     *
     * @param base for add
     * @return added or not
     */
    public boolean add(Base base) {
        boolean result = false;
        if (!storage.contains(base)) {
            storage.put(base.getId(), base);
            result = true;
        }
        return result;
    }

    /**
     * Method for update the value
     *
     * @param base for update
     * @return updated or not
     */
    public boolean update(Base base) {
        boolean result = false;
        if (storage.get(base.getId()).getVersion() != base.getVersion() + 1) {
            storage.computeIfPresent(base.getId(), ((i, bas) -> bas.upgrade()));
            result = true;
        } else {
            throw new OptimisticException();
        }
        return result;
    }

    /**
     * Method for delete the value
     *
     * @param base for delete
     * @return deleted or not
     */
    public boolean delete(Base base) {
        boolean result = false;
        if (storage.contains(base)) {
            storage.remove(base.getId());
            result = true;
        }
        return result;
    }
}
