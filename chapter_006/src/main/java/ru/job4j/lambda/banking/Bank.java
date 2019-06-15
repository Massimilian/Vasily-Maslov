package ru.job4j.lambda.banking;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bank {
    private Map<User, List<Account>> info = new HashMap<>();

    public Map<User, List<Account>> getInfo() {
        return info;
    }

    public void addUser(User user) {
        info.putIfAbsent(user, Collections.singletonList(new Account(0D)));
    }

    public void deleteUser(User user) {
        if (info.get(user).stream().filter(g -> g.getValue() != 0).collect(Collectors.toList()).size() > 0) {
            System.out.println("False! You have money or dept on you account.");
        } else {
            info.remove(user);
        }
    }

    public void addAccountToUser(String passport, Account account) {
        if (hasUser(passport)) {
            info.computeIfPresent(getUser(passport), (t, v) -> Stream.of(info.get(getUser(passport)), Arrays.asList(account)).flatMap(Collection::stream).collect(Collectors.toList()));
        } else {
            System.out.println("False! There is no any account with this passport!");
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        if (hasUser(passport)) {
            info.get(getUser(passport)).remove(account);
        } else {
            System.out.println("The user with this passport hasn't been found!");
        }
    }

    public List<Account> getUserAccounts(String passport) {
        return info.get(getUser(passport));
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        Boolean correct = false;
        if (getAccount(getUser(srcPassport), srcRequisite).getValue() >= amount) {
            getAccount(getUser(srcPassport), srcRequisite).setValue(getAccount(getUser(srcPassport), srcRequisite).getValue() - amount);
            getAccount(getUser(destPassport), dstRequisite).setValue(getAccount(getUser(destPassport), dstRequisite).getValue() + amount);
            correct = true;
        }
        return correct;
    }

    private User getUser(String passport) {
        return info.keySet().stream().filter(p -> p.getPassport().equals(passport)).collect(Collectors.toList()).get(0);
    }

    private boolean hasUser(String passport) {
        return info.keySet().contains(new User(passport));
    }

    private Account getAccount(User user, String requisites) {
        return info.get(user).stream().filter(p -> p.getRequisites().equals(requisites)).collect(Collectors.toList()).get(0);
    }
}
