package ru.job4j.map;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestMap {
    public static final class User {
        public String name;

        @Override
        public String toString() {
            return "User{" + "name='" + name + '\'' + '}';
        }

        public User(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

    @Test
    public void test() {
        User first = new User("Petr");
        User second = new User("Petr");
        System.out.println(first.hashCode() == second.hashCode());

        Map<User, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");

        System.out.println(map);
    }
}


