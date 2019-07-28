package ru.job4j.crudservlet;

import net.jcip.annotations.ThreadSafe;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Logic Layout.
 */
@ThreadSafe
public class ValidateService implements Store {
    private static ValidateService instance;
    private final List<User> list = new LinkedList<User>();
    private ReentrantLock lock = new ReentrantLock();
    private long value;

    public List<User> getList() {
        return list;
    }

    public long getValue() {
        value++;
        return value;
    }

    public static ValidateService getValidateService() {
        if (instance == null) {
            instance = new ValidateService();
        }
        return instance;
    }

    private ValidateService() {
    }

    @Override
    public boolean add(User user) {
        boolean res = false;
        lock.tryLock();
        if (!instance.getList().contains(user)) {
            instance.getList().add(user);
            res = true;
        }
        lock.unlock();
        return res;
    }

    @Override
    public boolean update(User user) {
        boolean res = false;
        lock.tryLock();
        if (instance.getList().contains(user)) {
            instance.getList().remove(this.find(user.getId()));
            instance.getList().add(user);
            res = true;
        }
        lock.unlock();
        return res;
    }

    @Override
    public boolean delete(User user) {
        boolean res = false;
        lock.tryLock();
        if (instance.getList().contains(user)) {
            instance.getList().remove(user);
            res = true;
        }
        lock.unlock();
        return res;
    }

    @Override
    public List<User> findAll(List<Long> ids) {
        lock.tryLock();
        List<User> result = ids.stream().map(instance::find).flatMap(Stream::ofNullable).collect(Collectors.toList());
        lock.unlock();
        return result;
    }

    @Override
    public void deleteAll() {
        lock.tryLock();
        instance.getList().clear();
        lock.unlock();
    }

    private User find(long id) {
        User result = null;
        synchronized (instance.getList()) {
            if (instance.getList().contains(new User(id, "", "", "", new Date()))) {
                result = instance.getList().get(instance.getList().indexOf(new User(id, "", "", "", new Date())));
            }
        }
        return result;
    }
}
