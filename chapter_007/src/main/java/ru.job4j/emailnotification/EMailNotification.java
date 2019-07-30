package ru.job4j.emailnotification;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EMailNotification {
    private final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void emailTo(User user) {
        String subject = String.format("Notification %s to e-mail %s.", user.getUserName(), user.getEmail());
        String body = String.format("Add a new body %s.", user.getEmail());
        pool.submit(() -> send(subject, body, user.getEmail()));
    }

    public void send(String subject, String body, String email) {
        // empty method
    }

    public void close() {
        this.pool.shutdown();
    }

}
