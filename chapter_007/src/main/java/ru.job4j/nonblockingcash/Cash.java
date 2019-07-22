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
     */
    public void add(Base base) {
        if (storage.contains(base)) {
            this.reNew(base);
        } else {
            storage.put(base.getId(), base);
        }
    }

    /**
     * Method for upgrade the value
     *
     * @param base to upgrade
     */
    public void reNew(Base base) {
        int version = storage.get(base.getId()).getVersion();
        base.setVersion(base.getVersion() + 1);
        if (version == base.getVersion()) {
            throw new OptimisticException();
        } else {
            storage.computeIfPresent(base.getId(), ((i, bas) -> base));
        }
    }
}
