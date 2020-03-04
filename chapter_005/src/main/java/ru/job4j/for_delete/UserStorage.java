package ru.job4j.for_delete;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserStorage {
    // Класс для хранения пользователей.
    // Делаем его синглетоном - чтобы можно было работать в режиме мнгопоточности.
    private static final UserStorage instance = new UserStorage();
    private List<User> users = new CopyOnWriteArrayList<User>();

    // дефолтный конструктор синглетона
    private UserStorage() {
        this.users.add(new User("root", "mail@mail.root", "root"));
    }

    // instance синглетона
    public static UserStorage getInstance() {
        return instance;
    }

    // метод по добавлению user
    public void add(User user) {
        this.users.add(user);
    }

    // метод по возвращению листа экземпляров User.
    public List<User> getUsers() {
        return this.users;
    }

    // метод для проверки существования такого User,  у которого есть такие login и password
    public boolean isCredentional(String login, String password) {
        boolean result = false;
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
