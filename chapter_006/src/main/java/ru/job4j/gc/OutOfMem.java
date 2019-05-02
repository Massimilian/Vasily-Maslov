package ru.job4j.gc;

public class OutOfMem {
    public static void main(String[] args) {
        User[] user = new User[10000000];
        for (int i = 0; i < 10000000; i++) {
            user[i] = new User(i);
        }
    }
}
