package ru.job4j.emailnotification;

public class User {
    final private String reg = "[\\w]+@[\\w]+\\.[a-z]{2,5}";
    private String userName;
    private String email;

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
        System.out.printf("%s%s", check() ? "User made." : "Incorrect e-mail, please change.", System.lineSeparator());
    }

    private boolean check() {
        return email.matches(reg); // простейшая проверка на соответствие реальному адресу почты
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getReg() {
        return reg;
    }
}
