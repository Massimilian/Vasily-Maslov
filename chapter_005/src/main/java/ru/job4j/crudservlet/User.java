package ru.job4j.crudservlet;

import java.util.Date;
import java.util.Objects;

/**
 * Base class for work.
 */
public class User {
    private final long id;
    private final String name;
    private final String login;
    private final String email;
    private final Date createDate;
    private String photoId;

    /**
     * Special constructor for add VALIDATE parameters.
     *
     * @param id         without checking
     * @param name       only letters, first is Capital
     * @param login      only letters
     * @param email      only mail form
     * @param createDate this date
     */
    public User(long id, String name, String login, String email, Date createDate) {
        this.id = id;
        this.name = name.matches("[A-Z][A-Za-z]+") ? name : "Unknown_name";
        this.login = login.matches("[\\w]+") ? login : "Unknown_login";
        this.email = email.matches("[A-Za-z0-9]+@[a-z0-9]+[.][a-z]{0,5}") ? email : "Unknown_e-mail";
        this.createDate = createDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getPhotoId() {
        return photoId;
    }

    /**
     * equals by id
     *
     * @param o another User
     * @return equals or not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
