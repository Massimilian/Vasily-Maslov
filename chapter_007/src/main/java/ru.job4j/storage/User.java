package ru.job4j.storage;

import java.util.Objects;

public class User {
    private final int ID;
    private int amount;

    public User(int ID) {
        this.ID = ID;
    }

    public User(int ID, int amount) {
        this.ID = ID;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return ID == user.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
