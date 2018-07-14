package ru.job4j.map.users;

import java.util.Calendar;
import java.util.Objects;

public class UserWithEqualsAndHash extends AbstractUser {

    public UserWithEqualsAndHash(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AbstractUser) {
            UserWithEqualsAndHash uweah = (UserWithEqualsAndHash) obj;
            return uweah.birthday.equals(this.birthday) && uweah.children == this.children && uweah.name.equals(this.name);
        }
        return false;
    }
}
