package ru.job4j.lasttask;

import ru.job4j.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class Store {

    public int[] diff(List<User> previous, List<User> current) {
        int[] result = new int[3];
        result[0] = howMuchNew(previous, current);
        result[1] = howMuchChanged(previous, current);
        result[2] = howMuchDeleted(previous, current);
        return result;
    }

    private int howMuchNew(List<User> previous, List<User> current) {
        int result = 0;
        for (User user : current) {
            if (!previous.contains(user)) {
                result++;
            }
        }
        return result;
    }

    public int howMuchChangedAlternative(List<User> previous, List<User> current) {
        HashMap<Integer, String> map = new HashMap<>();
        int result = 0;
        for (User user : previous) {
            map.put(user.getId(), user.getName());
        }
        for (User user : current) {
            if (map.containsKey(user.getId()) && !map.containsValue(user.getName())) {
                result++;
            }
        }
        return result;
    }


    private int howMuchChanged(List<User> previous, List<User> current) {
        int result = 0;
        Iterator<User> preIt = previous.iterator();
        while (preIt.hasNext()) {
            User tempPre = preIt.next();
            Iterator<User> curIt = current.iterator();
            while (curIt.hasNext()) {
                User tempCur = curIt.next();
                if (tempPre.getId() == tempCur.getId() && !tempPre.getName().equals(tempCur.getName())) {
                    result++;
                }
            }
        }
        return result;
    }

    private int howMuchDeleted(List<User> previous, List<User> current) {
        int result = 0;
        for (Object prev : previous) {
            if (!current.contains(prev)) {
                result++;
            }
        }
        return result;
    }
}

