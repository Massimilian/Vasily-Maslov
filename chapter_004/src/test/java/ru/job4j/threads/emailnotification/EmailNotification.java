package ru.job4j.threads.emailnotification;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 1. Реализовать сервис для рассылки почты. Создайте класс EmailNotification.
public class EmailNotification {
    private ExecutorService pool;

// 2. В классе будет метод emailTo(User user) - он должен через ExecutorService отправлять почту.
// 4. Метод emailTo должен брать данные пользователя и подставлять в шаблон
    public void emailTo(User user) {
        String subject = "Notification " + user.userName + " to mail " + user.mail;
        String body = "Add a new event to " + user.userName;
// 6. Через ExecutorService создайте задачу, которая будет создать данные для пользователя и передавать из в метод send.
        pool.execute(() -> send(subject, body, user.mail));
    }

//  2a.  Так же добавьте метод close() - он должен загрузить pool.
//       То есть в классе EmailNotification должно быть поле pool, которые используется в emailTo и close().
    public void close() {
        this.pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); // почему нельзя сразу же загрузить pool - ещё при создании класса?
    }

//  5. создайте метод public void send(String subject, String body, String email) - он должен быть пустой.
    private void send(String subject, String body, String email) {

    }
}
