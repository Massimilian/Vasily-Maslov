package ru.job4j.sortuser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortUserTest {
    private SortUser su = new SortUser();
    private User user1 = new User("NoName", 25);
    private User user2 = new User("NoName", 26);
    private User user3 = new User("HasName", 24);
    private User user4 = new User("First", 99);

    @Test
    public void whenAskSortedSetThenReturnIt() {
        su.users.addAll(Arrays.asList(user1, user2, user3, user4));
        assertThat(su.users, is(new ArrayList<>(Arrays.asList(user3, user1, user2, user4))));
    }
}
