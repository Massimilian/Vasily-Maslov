package ru.job4j.generics;

import java.util.Iterator;

public class UserStore extends AbstractStore<User> {

    public UserStore(int size) {
        this.userSa = new SimpleArray<>(size);
        super.size = size;
    }

    @Override
    public User findById(String id) {
        User user = new User(null);
        for (int i = 0; i < size; i++) {
            User t = (User) this.userSa.get(i);
            if (t != null && t.getId().equals(id)) {
                user = t;
                break;
            }
        }
        return user;
    }
}
