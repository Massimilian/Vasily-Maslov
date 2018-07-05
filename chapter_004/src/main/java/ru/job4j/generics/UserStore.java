package ru.job4j.generics;

import java.util.Iterator;

public class UserStore extends AbstractStore implements Store<User> {

    public UserStore(int size) {
        this.userSa = new SimpleArray<>(size);
        super.size = size;
    }

    @Override
    public void add(User model) {
        this.userSa.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        boolean done = false;
        User user = findById(id);
        if (user.getId() != null) {
            userSa.set(userSa.findIndex(user), model);
            done = true;
        }
        return done;
    }

    @Override
    public boolean delete(String id) {
        boolean done = false;
        User user = findById(id);
        if (user.getId() != null) {
            this.userSa.delete(userSa.findIndex(user));
            done = true;
        }
        return done;
    }

    @Override
    public User findById(String id) {
        User user = new User(null);
        for (int i = 0; i < size; i++) {
            User t = this.userSa.get(i);
            if (t != null && t.getId().equals(id)) {
                user = t;
                break;
            }
        }
        return user;
    }
}
