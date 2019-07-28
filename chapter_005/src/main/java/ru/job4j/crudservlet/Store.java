package ru.job4j.crudservlet;

import java.util.List;

/**
 * Base interface for storing users.
 */
public interface Store {
    public long getValue();

    public List<User> getList();

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
