package ru.job4j.crudservlet;

import net.jcip.annotations.ThreadSafe;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Logic Layout.
 */
@ThreadSafe
public class ValidateService implements Store {
    private static final ValidateService instance = new ValidateService();
    private final List<User> list = new CopyOnWriteArrayList<>();
    AtomicInteger value = new AtomicInteger(0);

    public List<User> getList() {
        return list;
    }

    public int getValue() {
        return value.incrementAndGet();
    }

    public static ValidateService getValidateService() {
        return instance;
    }

    private ValidateService() {
    }

    @Override
    public boolean add(User user) {
        boolean res = false;
        if (!instance.getList().contains(user)) {
            instance.getList().add(user);
            res = true;
        }
        return res;
    }

    @Override
    public boolean update(User user) {
        boolean res = false;
        if (instance.getList().contains(user)) {
            instance.getList().remove(this.find(user.getId()));
            instance.getList().add(user);
            res = true;
        }
        return res;
    }

    @Override
    public boolean delete(User user) {
        boolean res = false;
        if (instance.getList().contains(user)) {
            instance.getList().remove(user);
            res = true;
        }
        return res;
    }

    @Override
    public List<User> findAll(List<Long> ids) {
        return ids.stream().map(instance::find).flatMap(Stream::ofNullable).collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        instance.getList().clear();
    }

    private User find(long id) {
        User result = null;
        if (instance.getList().contains(new User(id, "", "", "", new Date()))) {
            result = instance.getList().get(instance.getList().indexOf(new User(id, "", "", "", new Date())));
        }
        return result;
    }
}
