package ru.job4j.crudservlet;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateServiceTest {
    private User userZero = new User(0, "Zero", "Zero", "zero@zero.com", new Date(), null);
    private User userAnotherZero = new User(0, "AnotherZero", "AnotherZero", "anotherZero@zero.com", new Date(), null);
    private User userOne = new User(1, "One", "One", "one@one.com", new Date(), null);

    @Test
    public void whenAddNewValueThenPutItInTheList() {
        ValidServ.getValidateService().deleteAll();
        assertThat(ValidServ.getValidateService().add(userZero), is(true));
        assertThat(ValidServ.getValidateService().add(userZero), is(false));
        assertThat(ValidServ.getValidateService().getList().size(), is(1));
        assertThat(ValidServ.getValidateService().getList().get(0).getEmail(), is("zero@zero.com"));
    }

    @Test
    public void whenDeleteOldValueThenPutItOutFromTheList() {
        ValidServ.getValidateService().deleteAll();
        assertThat(ValidServ.getValidateService().add(userZero), is(true));
        assertThat(ValidServ.getValidateService().delete(userZero), is(true));
        assertThat(ValidServ.getValidateService().delete(userZero), is(false));
        assertThat(ValidServ.getValidateService().getList().size(), is(0));
    }

    @Test
    public void whenFindSomeValuesThenReturnThem() {
        ValidServ.getValidateService().deleteAll();
        assertThat(ValidServ.getValidateService().add(userZero), is(true));
        assertThat(ValidServ.getValidateService().add(userOne), is(true));
        List<User> found = ValidServ.getValidateService().findAll(List.of(0L, 1L, 2L));
        assertThat(found.size(), is(2));
        assertThat(found.get(0), is(userZero));
        assertThat(found.get(1), is(userOne));
    }

    @Test
    public void whenTryToRenovateValueThenDoIt() {
        ValidServ.getValidateService().deleteAll();
        assertThat(ValidServ.getValidateService().update(userAnotherZero), is(false));
        assertThat(ValidServ.getValidateService().add(userZero), is(true));
        assertThat(ValidServ.getValidateService().update(userAnotherZero), is(true));
        assertThat(ValidServ.getValidateService().getList().size(), is(1));
        assertThat(ValidServ.getValidateService().getList().get(0).getLogin(), is("AnotherZero"));
        assertThat(ValidServ.getValidateService().delete(userAnotherZero), is(true));
    }
}
