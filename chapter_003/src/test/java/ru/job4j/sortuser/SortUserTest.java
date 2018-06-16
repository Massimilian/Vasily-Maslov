package ru.job4j.sortuser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortUserTest {
    private SortUser su = new SortUser();
    private User user1 = new User("NoName", 25);
    private User user2 = new User("ForgotName", 26);
    private User user3 = new User("TheLast", 99);
    private User user4 = new User("HasName", 27);
    List<User> list = new ArrayList<>(Arrays.asList(user1, user2, user3, user4));


    @Test
    public void whenAskSortedSetFromListThenReturnIt() {
        assertThat(su.sort(list), is(new TreeSet<User>(Arrays.asList(user1, user2, user4, user3))));
    }

    @Test
    public void whenAskSortedListLightVersionThenReturnIt() {
        assertThat(su.sortNameLength(list), is(new ArrayList<User>(Arrays.asList(user1, user3, user4, user2))));
    }

    @Test
    public void whenAskSortedListDeepVersionThenReturnIt() {
        assertThat(su.sortByAllFields(list), is(new ArrayList<User>(Arrays.asList(user1, user4, user3, user2))));
    }

}
