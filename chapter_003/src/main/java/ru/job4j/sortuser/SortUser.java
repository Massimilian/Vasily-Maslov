package ru.job4j.sortuser;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> list) {
        TreeSet<User> result = new TreeSet<>();
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }

    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = Integer.compare(o1.getName().length(), o2.getName().length());
                return result == 0 ? Integer.compare(o1.getAge(), o2.getAge()) : result;
            }
        });
        return list;
    }
}



