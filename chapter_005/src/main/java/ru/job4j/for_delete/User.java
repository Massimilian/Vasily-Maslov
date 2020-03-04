package ru.job4j.for_delete;

public class User {
    private String login;
    private String mail;
    private String password;

    public User(String login, String mail, String password) {
        this.login = login;
        this.mail = mail;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}
