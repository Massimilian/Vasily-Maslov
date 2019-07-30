package ru.job4j.crudservlet;

import java.util.Date;

/**
 * Logic layout. Class for careful actions with store.
 */
public class Controller {
    private final Store logic;
    String info = "Program started.";
    String separator = "&";

    public Controller(Store logic) {
        this.logic = logic;
    }

    public String getInfo() {
        return info;
    }

    /**
     * Preparing the clients request in response
     *
     * @param input from client
     */
    public void works(String input) {
        this.info = "Unknown operation";
        if (input.matches("add&.*")) {
            User forAdd = this.prepare(input, false);
            if (forAdd != null) {
                this.info = logic.add(forAdd) ? "New user added." : "Error! This adding is aborted.";
            }
        } else if (input.matches("update&.*")) {
            User forUpdate = this.prepare(input, true);
            if (forUpdate != null) {
                this.info = logic.update(forUpdate) ? "User updated." : "Error! This updating is aborted.";
            }
        } else if (input.matches("delete&.*")) {
            User forDelete = this.prepare(input, true);
            if (forDelete != null) {
                this.info = logic.delete(forDelete) ? "User deleted." : "Error! This deleting is aborted";
            }
        }
    }

    /**
     * Preparing information about store status
     *
     * @return ready report.
     */
    public String report() {
        String result = "";
        for (User u : logic.getList()) {
            result = this.oneByOne(result, u);
        }
        return result;
    }

    /**
     * @param input is contains the information about request
     * @param spec  for correct the specification of User
     * @return prepared User
     */
    private User prepare(String input, boolean spec) {
        String[] split = input.split(separator);
        User prep = null;
        if (split.length >= 4 && !spec) {
            prep = new User(logic.getValue(), split[1], split[2], split[3], new Date());
        }
        if (split.length >= 5 && spec) {
            int id = 0;
            boolean correct = true;
            try {
                id = Integer.parseInt(split[1]);
            } catch (Exception e) {
                correct = false;
            }
            if (correct) {
                prep = new User(id, split[2], split[3], split[4], new Date());
            }
        }
        return prep;
    }

    /**
     * Preparing one User for show
     *
     * @param sb   show string
     * @param user for show.
     * @return
     */
    private String oneByOne(String sb, User user) {
        return String.format("%sUser ID: %s;%sUser name: %s;%sUser login: %s;%sUser mail: %s;%sUser create date: %s;%s%s%s%s",
                sb, user.getId(), System.lineSeparator(), user.getName(), System.lineSeparator(), user.getLogin(), System.lineSeparator(),
                user.getEmail(), System.lineSeparator(), user.getCreateDate(), System.lineSeparator(), "*******", System.lineSeparator(), System.lineSeparator());
    }
}
