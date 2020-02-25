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
public class ValidServ implements Store {
    private static final ValidServ INST = new ValidServ();
    private final List<User> list = new CopyOnWriteArrayList<>();
    Color color = new Color();
    private String command;
    AtomicInteger value = new AtomicInteger(0);

    public Color getColor() {
        return INST.color;
    }

    public List<User> getList() {
        return list;
    }

    public int getValue() {
        return value.incrementAndGet();
    }

    public static ValidServ getValidateService() {
        return INST;
    }

    private ValidServ() {
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public boolean add(User user) {
        boolean res = false;
        if (!INST.getList().contains(user)) {
            INST.getList().add(user);
            res = true;
        }
        return res;
    }

    @Override
    public boolean update(User user) {
        boolean res = false;
        if (INST.getList().contains(user)) {
            INST.getList().remove(this.find(user.getId()));
            INST.getList().add(user);
            res = true;
        }
        return res;
    }

    @Override
    public boolean delete(User user) {
        boolean res = false;
        if (INST.getList().contains(user)) {
            INST.getList().remove(user);
            res = true;
        }
        return res;
    }

    @Override
    public List<User> findAll(List<Long> ids) {
        return ids.stream().map(INST::find).flatMap(Stream::ofNullable).collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        INST.getList().clear();
    }

    @Override
    public boolean userCheck(String login) {
        return false;
    }

    @Override
    public boolean adminCheck(String login, String password) {
        return false;
    }

    private User find(long id) {
        User result = null;
        if (INST.getList().contains(new User(id, "", "", "", new Date(), null))) {
            result = INST.getList().get(INST.getList().indexOf(new User(id, "", "", "", new Date(), null)));
        }
        return result;
    }
}
