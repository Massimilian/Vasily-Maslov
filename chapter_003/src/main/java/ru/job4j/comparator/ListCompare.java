package ru.job4j.comparator;

import java.util.ArrayList;

public class ListCompare {
    public int compare(String left, String right) {
        int result = 0;
        ArrayList<Character> leftList = makeList(left);
        ArrayList<Character> rightList = makeList(right);
        int size = rightList.size() > leftList.size() ? leftList.size() : rightList.size();
        for (int i = 0; i < size; i++) {
            result = Character.compare(rightList.get(i), leftList.get(i));
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            if (rightList.size() < leftList.size()) {
                result = 1;
            }
            if (leftList.size() < rightList.size()) {
                result = -1;
            }
        }
        return result;
    }

    private ArrayList<Character> makeList(String str) {
        ArrayList<Character> list = new ArrayList<Character>();
        for (char ch : str.toCharArray()) {
            list.add(ch);
        }
        return list;
    }
}