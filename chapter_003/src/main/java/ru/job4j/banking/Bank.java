package ru.job4j.banking;

import java.util.*;

public class Bank {
    private TreeMap<User, List<Account>> bankUsers = new TreeMap<>();

    public TreeMap<User, List<Account>> getBankUsers() {
        return bankUsers;
    }

    public void setBankUsers(TreeMap<User, List<Account>> bankUsers) {
        this.bankUsers = bankUsers;
    }

    // - добавление пользователя.
    public void addUser(User user) {
        bankUsers.putIfAbsent(user, new ArrayList<>(Collections.singletonList(new Account())));
    }

    //- удаление пользователя.
    public void deleteUser(User user) {
        boolean mayBeDeleted = false;
        if (!bankUsers.isEmpty()) {
            mayBeDeleted = true;
            Iterator<Account> it = bankUsers.get(user).iterator();
            while (it.hasNext()) {
                if (it.next().getValue() != 0) {
                    mayBeDeleted = false;
                    System.out.println("You can't revoke this account!");
                }
            }
        }
        if (mayBeDeleted) {
            System.out.printf("The account of %s, passport number %s will be deleted.", user.getName(), user.getPassport());
            bankUsers.remove(user);
        }
    }

    // - добавить счёт пользователю.
    public void addAccountToUser(String passport, Account account) {
        User user = this.findUser(passport);
        if (user == null) {
            System.out.printf("The client with passport number %s hasn't been found!", passport);
        } else {
            bankUsers.get(user).add(account);
        }
    }

    // - удалить один счёт пользователя.
    public void deleteAccountFromUser(String passport, Account account) {
        User user = this.findUser(passport);
        if (user == null) {
            System.out.printf("The client with passport number %s hasn't been found!", passport);
        } else {
            System.out.printf("The Account number %s will be deleted.\n", account.getRequisites());
            bankUsers.get(user).remove(account);
            if (bankUsers.get(user).size() == 0) {
                System.out.println("You have not more Accounts in this bank. Good-bye!");
                deleteUser(user);
            }
        }
    }

    // - получить список счетов для пользователя.
    public List<Account> getUserAccounts(String passport) {
        User user = this.findUser(passport);
        if (user == null) {
            System.out.printf("The client with passport number %s hasn't been found!", passport);
        }
        return bankUsers.get(user);
    }

    // - метод для перечисления денег с одного счёта на другой счёт:
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean operationWorked = true;
        User srcUser = this.findUser(srcPassport);
        User destUser = this.findUser(destPassport);
        int srcReqNum = this.findAccountNumber(srcUser, srcRequisite);
        int destReqNum = this.findAccountNumber(destUser, destRequisite);
        if (srcUser != null && destUser != null && srcReqNum != -1 && destReqNum != -1 && bankUsers.get(srcUser).get(srcReqNum).getValue() >= amount) {
            bankUsers.get(srcUser).get(srcReqNum).setValue(bankUsers.get(srcUser).get(srcReqNum).getValue() - amount);
            bankUsers.get(destUser).get(destReqNum).setValue(bankUsers.get(destUser).get(destReqNum).getValue() + amount);
            System.out.println("Operation successfully finished!");
        } else {
            System.out.println("Operation interrupted!");
            operationWorked = false;
        }
        return operationWorked;
    }

    private User findUser(String passport) {
        User user = null;
        for (Map.Entry<User, List<Account>> entry : this.bankUsers.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                user = entry.getKey();
                break;
            }
        }
        return user;
    }

    private int findAccountNumber(User user, String requisites) {
        int result = -1;
        for (int i = 0; i < bankUsers.get(user).size(); i++) {
            if (bankUsers.get(user).get(i).getRequisites().equals(requisites)) {
                result = i;
            }
        }
        return result;
    }
}
