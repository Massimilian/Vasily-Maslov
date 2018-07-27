package ru.job4j.threads.userstorage;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserStorageTest {
    UserStorage us = new UserStorage();
    User user1 = new User(1, 100);
    User user2 = new User(2, 0);

    @Test
    public void whenTravel100ThenDoIt() {
        us.add(user1);
        us.add(user2);
        us.transfer(1, 2, 100);
        HashMap<Integer, Integer> users = us.getUsers();
        assertThat(users.get(1), is(0));
        assertThat(users.get(2), is(100));
    }
}
