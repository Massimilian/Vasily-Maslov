package ru.job4j.sortuser;

public class User implements Comparable<User> {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        int result = this.name.compareTo(o.name);
        return result == 0 ? Integer.compare(this.age, o.age) : result;
    }


}
