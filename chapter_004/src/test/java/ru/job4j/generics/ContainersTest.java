package ru.job4j.generics;

import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class ContainersTest {
    UserStore users = new UserStore(3);
    User user1 = new User("1");
    User user2 = new User("2");
    User user3 = new User("3");

    @Test
    public void whenTryToAddThenReturnItIntoSimpleList() {
        users.add(user1);
        users.add(user2);
        users.add(user3);
        assertThat(users.findById("1"), is(user1));
        assertThat(users.findById("2"), is(user2));
        assertThat(users.findById("3"), is(user3));
    }

    @Test
    public void whenTryToReplaceByIdThenDoIt() {
        users.add(user3);
        users.replace("3", user1);
        assertThat(users.findById("1"), is(user1));
    }

    @Test
    public void whenAskToDeleteByIdThenDoIt() {
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.delete("1");
        assertThat(users.findById("1").getId(), is (nullValue()));
    }


}
