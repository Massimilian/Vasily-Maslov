package ru.job4j.map.Users;

import java.util.Calendar;

public class UserWithEquals extends AbstractUser {

    public UserWithEquals(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AbstractUser) {
            UserWithEquals uwe = (UserWithEquals) obj;
            if (uwe.birthday.equals(this.birthday) && uwe.children == this.children && uwe.name.equals(this.name)) {
                return true;
            }
        }
        return false;
    }
}
