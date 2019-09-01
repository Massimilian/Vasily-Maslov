package ru.job4j.crudservlet;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Base interface for storing users.
 */
public interface Store {
    public int getValue();
    public List<User> getList();


    public String getCommand();

    public void setCommand(String command);

    /**
     * Add new User
     *
     * @param user for add
     * @return added or not
     */
    public boolean add(User user);

    /**
     * Update old user
     *
     * @param user for update
     * @return updated or not
     */
    public boolean update(User user);

    /**
     * Delete User from Store
     *
     * @param user for delete
     * @return deleted or not.
     */
    public boolean delete(User user);

    /**
     * Find and prepare all Users.
     *
     * @param ids of all Users for find
     * @return List of Users.
     */
    public List<User> findAll(List<Long> ids);

    /**
     * Clear the store.
     */
    public void deleteAll();
}
