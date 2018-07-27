package ru.job4j.threads.userstorage;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

import java.util.HashMap;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private HashMap<Integer, Integer> users = new HashMap<>();

    public HashMap<Integer, Integer> getUsers() {
        return users;
    }

    boolean add(User user) {
        users.put(user.getId(), user.getAmount());
        return true;
    }

    boolean update(User user) {
        boolean is = users.containsKey(user.getId());
        if (is) {
            this.add(user);
        }
        return is;
    }

    boolean delete(User user) {
        boolean is = users.containsKey(user.getId());
        if (is) {
            users.remove(user.getId());
        }
        return is;
    }

    public synchronized void transfer(int fromId, int toId, int amount) {
        if (users.containsKey(fromId) && users.containsKey(toId) && users.get(fromId) >= amount) {
            users.put(fromId, users.get(fromId) - amount);
            users.put(toId, users.get(toId) + amount);
            System.out.println("Operation completed.");
        } else {
            System.out.println("Impossible operation!");
        }
    }
}
