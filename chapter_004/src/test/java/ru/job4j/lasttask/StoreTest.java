package ru.job4j.lasttask;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StoreTest {
    private Store store = new Store();
    private List<User> list1 = new ArrayList<>();
    private List<User> list2 = new LinkedList<>();
    private User user1 = new User(1, "FirstName");
    private User user2 = new User(2, "SecondName");
    private User user3 = new User(3, "ThirdName");

    @Test
    public void whenAddNewUsersThenReturnInformationAboutThem() {
        list1.add(user1);
        list2.add(user1);
        list2.add(user2);
        list2.add(user3);
        assertThat(store.diff(list1, list2), is(new int[]{2, 0, 0}));
    }

    @Test
    public void whenLookForChangesThenReturnResult() {
        list1.add(user1);
        list1.add(user2);
        list1.add(user3);
        user2 = new User(2, "AnotherName");
        list2.add(user1);
        list2.add(user2);
        list2.add(user3);
        assertThat(store.diff(list1, list2), is(new int[]{0, 1, 0}));
    }

    @Test
    public void whenLookForDeletedUsersThenReturnResult() {
        list1.add(user1);
        list1.add(user2);
        list1.add(user3);
        list2.add(user1);
        list2.add(user2);
        assertThat(store.diff(list1, list2), is(new int[]{0, 0, 1}));
    }

    @Test
    public void whenWeHaveNewChangedAndDeletedUsersThenReturnInfoAboutTheirNumber() {
        list1.add(user1);
        list1.add(user2);
        user2 = new User(2, "AnotherName");
        list2.add(user2);
        list2.add(user3);
        assertThat(store.diff(list1, list2), is(new int[]{1, 1, 1}));
    }

}