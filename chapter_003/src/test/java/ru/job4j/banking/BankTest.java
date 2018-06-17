package ru.job4j.banking;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BankTest {
    private Bank bank = new Bank();
    private User user = new User("Aleksandr", "1234567890");
    private Account acc = new Account(10.5, "qwe123rty");
    private User user2 = new User("Natalia", "0987654321");
    private Account acc2 = new Account("ytr321ewq");
    private Account acc3 = new Account("hgf654dsa");
    private List<Account> list = new ArrayList<>(Collections.singletonList(acc));
    private List<Account> list2 = new ArrayList<>(Arrays.asList(acc2, acc3));

    @Test
    public void whenTryToAddNewUserThenDoIt() {
        TreeMap<User, List<Account>> tree = new TreeMap<>();
        tree.put(user, list);
        bank.setBankUsers(tree);
        User user3 = new User("Dmitry", "1357924680");
        bank.addUser(user3);
        assertThat(bank.getBankUsers().containsKey(user3), is(true));
    }

    @Test
    public void whenTryToDeleteTheUserWithNotNullAccountThenDoNotDoThat() {
        TreeMap<User, List<Account>> tree = new TreeMap<>();
        tree.put(user, list);
        bank.setBankUsers(tree);
        bank.deleteUser(user);
        assertThat(bank.getBankUsers().containsKey(user), is(true));
    }

    @Test
    public void whenTryToDeleteTheUserWithNullAccountThenDoThat() {
        TreeMap<User, List<Account>> tree = new TreeMap<>();
        tree.put(user2, list2);
        bank.setBankUsers(tree);
        bank.deleteUser(user2);
        assertThat(bank.getBankUsers().containsKey(user2), is(false));
    }

    @Test
    public void whenTryToAddANewAccountForUserThenDoThat() {
        TreeMap<User, List<Account>> tree = new TreeMap<>();
        tree.put(user, list);
        bank.setBankUsers(tree);
        bank.addUser(user2);
        bank.addAccountToUser(user2.getPassport(), acc2);
        assertThat(bank.getBankUsers().get(user2).get(1), is(acc2));
    }

    @Test
    public void whenTryToDeleteOneAccountThenDoIt() {
        TreeMap<User, List<Account>> tree = new TreeMap<>();
        tree.put(user, list);
        bank.setBankUsers(tree);
        bank.addAccountToUser(user.getPassport(), acc2);
        bank.deleteAccountFromUser(user.getPassport(), acc);
        assertThat(bank.getBankUsers().get(user).get(0), is(acc2));
        assertThat(bank.getBankUsers().get(user).size(), is(1));
    }

    @Test
    public void whenClientHaveNotAccountsInBankThenDeleteHim() {
        TreeMap<User, List<Account>> tree = new TreeMap<>();
        tree.put(user2, list2);
        bank.setBankUsers(tree);
        bank.deleteAccountFromUser(user2.getPassport(), acc3);
        bank.deleteAccountFromUser(user2.getPassport(), acc2);
        assertThat(bank.getBankUsers().containsKey(user2), is(false));
    }

    @Test
    public void whenAskAListOfAccountsThenReturnIt() {
        TreeMap<User, List<Account>> tree = new TreeMap<>();
        tree.put(user2, list2);
        bank.setBankUsers(tree);
        List<Account> result = bank.getUserAccounts(user2.getPassport());
        assertThat(result.containsAll(list2), is(true));
    }

    @Test
    public void whenTryToTransferMoneyFromAccountToAccountThenDoIt() {
        TreeMap<User, List<Account>> tree = new TreeMap<>();
        tree.put(user, list);
        tree.put(user2, list2);
        bank.setBankUsers(tree);
        assertThat(bank.transferMoney(user.getPassport(), acc.getRequisites(), user2.getPassport(), acc3.getRequisites(), 5), is(true));
        assertThat(bank.getBankUsers().get(user2).get(1).getValue(), is(5.0));
    }

    @Test
    public void whenTryToTransferTooMuchMoneyFromAccountToAccountThenDoNotDoIt() {
        TreeMap<User, List<Account>> tree = new TreeMap<>();
        tree.put(user, list);
        tree.put(user2, list2);
        bank.setBankUsers(tree);
        assertThat(bank.transferMoney(user.getPassport(), acc.getRequisites(), user2.getPassport(), acc3.getRequisites(), 15), is(false));
        assertThat(bank.getBankUsers().get(user2).get(1).getValue(), is(0.0));
    }

    @Test
    public void whenTryToTransferMoneyFromAccountToAccountThatDoNotExistsThenDoNotDoIt() {
        TreeMap<User, List<Account>> tree = new TreeMap<>();
        tree.put(user, list);
        tree.put(user2, list);
        bank.setBankUsers(tree);
        assertThat(bank.transferMoney(user.getPassport(), acc.getRequisites(), user2.getPassport(), acc3.getRequisites(), 1.5), is(false));
        assertThat(bank.getBankUsers().get(user2).get(0).getValue(), is(10.5));
    }
}
