package ru.job4j.map.Users;

import java.util.Calendar;
import java.util.Objects;

public class UserWithHash extends AbstractUser {

    public UserWithHash(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
