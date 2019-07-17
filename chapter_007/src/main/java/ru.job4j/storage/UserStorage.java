package ru.job4j.storage;

import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;

/**
 * Class of users keeper.
 */
@ThreadSafe
public class UserStorage {
    private final ArrayList<User> users = new ArrayList<User>();

    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Add new user
     *
     * @param user
     * @return true if added
     */
    public boolean add(User user) {
        boolean result = false;
        synchronized (users) {
            if (!users.contains(user)) {
                users.add(user);
                result = users.contains(user);
            }
        }
        return result;
    }

    /**
     * Update changed user
     *
     * @param user
     * @return true if updated
     */
    public boolean update(User user) {
        boolean result = false;
        synchronized (users) {
            if (users.contains(user)) {
                users.remove(user);
                users.add(user);
                result = users.contains(user);
            }
        }
        return result;
    }

    /**
     * Delete user
     *
     * @param user
     * @return true if deleted
     */
    public boolean delete(User user) {
        boolean result = false;
        synchronized (users) {
            if (users.contains(user)) {
                users.remove(user);
                result = !users.contains(user);
            }
        }
        return result;
    }

    /**
     * Transfer amount from X to Y
     *
     * @param fromId - payer
     * @param toId   - receiver
     * @param amount - number of amount
     * @return - true if transfer was successful
     */
    public boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        synchronized (users) {
            User from = users.get(users.indexOf(new User(fromId)));
            User to = users.get(users.indexOf(new User(toId)));
            if (from.getAmount() >= amount) {
                from.setAmount(from.getAmount() - amount);
                to.setAmount(to.getAmount() + amount);
                result = true;
            }
            this.update(from);
            this.update(to);
        }
        return result;
    }
}
