package ru.job4j.storage;


import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserStorageTest {
    private UserStorage stoge = new UserStorage();

    @Test
    public void whenTryToUseStorageThenUseItWell() {
        assertThat(stoge.add(new User(1, 100)), is(true));
        assertThat(stoge.add(new User(2, 200)), is(true));
        assertThat(stoge.transfer(1, 2, 50), is(true));
        assertThat(stoge.getUsers().get(0).getAmount(), is(50));
        assertThat(stoge.getUsers().get(1).getAmount(), is(250));
    }
}
