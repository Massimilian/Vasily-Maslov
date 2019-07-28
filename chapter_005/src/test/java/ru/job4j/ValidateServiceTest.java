package ru.job4j;

import org.junit.Test;
import ru.job4j.crudservlet.Controller;
import ru.job4j.crudservlet.User;
import ru.job4j.crudservlet.ValidateService;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateServiceTest {
    private User userZero = new User(0, "Zero", "Zero", "zero@zero.com", new Date());
    private User userAnotherZero = new User(0, "AnotherZero", "AnotherZero", "anotherZero@zero.com", new Date());
    private User userOne = new User(1, "One", "One", "one@one.com", new Date());

    @Test
    public void whenAddNewValueThenPutItInTheList() {
        ValidateService.getValidateService().deleteAll();
        assertThat(ValidateService.getValidateService().add(userZero), is(true));
        assertThat(ValidateService.getValidateService().add(userZero), is(false));
        assertThat(ValidateService.getValidateService().getList().size(), is(1));
        assertThat(ValidateService.getValidateService().getList().get(0).getEmail(), is("zero@zero.com"));
    }

    @Test
    public void whenDeleteOldValueThenPutItOutFromTheList() {
        ValidateService.getValidateService().deleteAll();
        assertThat(ValidateService.getValidateService().add(userZero), is(true));
        assertThat(ValidateService.getValidateService().delete(userZero), is(true));
        assertThat(ValidateService.getValidateService().delete(userZero), is(false));
        assertThat(ValidateService.getValidateService().getList().size(), is(0));
    }

    @Test
    public void whenFindSomeValuesThenReturnThem() {
        ValidateService.getValidateService().deleteAll();
        assertThat(ValidateService.getValidateService().add(userZero), is(true));
        assertThat(ValidateService.getValidateService().add(userOne), is(true));
        List<User> found = ValidateService.getValidateService().findAll(List.of(0L, 1L, 2L));
        assertThat(found.size(), is(2));
        assertThat(found.get(0), is(userZero));
        assertThat(found.get(1), is(userOne));
    }

    @Test
    public void whenTryToRenovateValueThenDoIt() {
        ValidateService.getValidateService().deleteAll();
        assertThat(ValidateService.getValidateService().update(userAnotherZero), is(false));
        assertThat(ValidateService.getValidateService().add(userZero), is(true));
        assertThat(ValidateService.getValidateService().update(userAnotherZero), is(true));
        assertThat(ValidateService.getValidateService().getList().size(), is(1));
        assertThat(ValidateService.getValidateService().getList().get(0).getLogin(), is("AnotherZero"));
        assertThat(ValidateService.getValidateService().delete(userAnotherZero), is(true));
    }
}
