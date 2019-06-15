package ru.job4j.lambda.banking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BankTest {
    private Bank bank = new Bank();
    private String passport = "passport";
    private String anotherPassport = "another passport";
    private User userOne = new User(passport);
    private User userTwo = new User(anotherPassport);
    private Account second = new Account(0D, "The second");
    private Account third = new Account(0D, "The third");
    private Account wrong = new Account(0D, "Wrong!");
    private Account rich = new Account(1000000, "Rich!!!");

    @Test
    public void whenTryToPutNewClientThenDoIt() {
        bank.addUser(userOne);
        assertThat(bank.getInfo().size() == 1, is(true));
        assertThat(bank.getInfo().get(new User(passport)).get(0).getValue(), is(0D));
    }

    @Test
    public void whenTryToDeleteTheClientThenFinallyDoIt() {
        bank.addUser(userOne);
        bank.getInfo().get(userOne).get(0).setValue(100D);
        bank.deleteUser(userOne);
        assertThat(bank.getInfo().size() == 0, is(false));
        bank.getInfo().get(userOne).get(0).setValue(0D);
        bank.deleteUser(userOne);
        assertThat(bank.getInfo().isEmpty(), is(true));
    }

    @Test
    public void whenAddNewAccountToUserThenDoIt() {
        bank.addUser(userOne);
        bank.addUser(userTwo);
        assertThat(bank.getInfo().get(userTwo).size(), is(1));
        bank.addAccountToUser("wrong passport", second);
        assertThat(bank.getInfo().get(userOne).size(), is(1));
        assertThat(bank.getInfo().get(userTwo).size(), is(1));
        bank.addAccountToUser(anotherPassport, second);
        assertThat(bank.getInfo().get(userTwo).size(), is(2));
        bank.addAccountToUser(anotherPassport, third);
        assertThat(bank.getInfo().get(userTwo).size(), is(3));
    }

    @Test
    public void whenGetUserAccountsTheDoIt() {
        bank.addUser(userOne);
        bank.addAccountToUser(passport, second);
        bank.addAccountToUser(passport, third);
        assertThat(new ArrayList<>(bank.getInfo().get(userOne)), is(bank.getUserAccounts(userOne.getPassport())));
        assertThat(bank.getUserAccounts(userOne.getPassport()).size(), is(3));
    }

    @Test
    public void whenTryToPutOutTheAccountThenDoIt() {
        bank.addUser(userOne);
        bank.addUser(userTwo);
        bank.addAccountToUser(passport, second);
        bank.addAccountToUser(passport, wrong);
        bank.deleteAccountFromUser(passport, wrong);
        assertThat(bank.getUserAccounts(userOne.getPassport()).size(), is(2));
    }

    @Test
    public void whenTryToMakeTransferMoneyThenDoItWell() {
        bank.addUser(userOne);
        bank.addAccountToUser(passport, rich);
        bank.addUser(userTwo);
        bank.addAccountToUser(anotherPassport, second);
        bank.transferMoney(passport, "Rich!!!", anotherPassport, "The second", 999999);
        System.out.println();
    }

    @Test
    public void whenTryToGetAllAccountsThenDoIt() {
        bank.addUser(userOne);
        bank.addAccountToUser(passport, second);
        bank.addAccountToUser(passport, third);
        bank.addAccountToUser(passport, wrong);
        assertThat(bank.getUserAccounts(passport), is(Arrays.asList(new Account(0D), second, third, wrong)));
    }
}