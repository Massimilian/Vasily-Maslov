package ru.job4j.lambda.address;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class AddressTest {
    private Profiles p = new Profiles();
    private List<Profile> clients = new ArrayList<>();
    private Address a = new Address("City", "Street", 1, 1);

    @Test
    public void whenTryToMakeAddressListThenDoIt() {
        this.fillAll();
        List<Address> result = p.collect(clients);
        assertThat(result.size(), is(3));
        assertThat(result.get(0).equals(a), is(true));
        assertThat(result.get(1).equals(a), is(false));
    }

    private void fillAll() {
        this.clients.add(new Profile(a));
        this.clients.add(new Profile(a));
        this.clients.add(new Profile(new Address("NoCity", "NoStreet", 0, 0)));
        this.clients.add(new Profile(new Address("", "", -1, -1)));
    }
}
