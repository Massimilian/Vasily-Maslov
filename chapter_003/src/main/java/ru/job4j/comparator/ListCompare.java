package ru.job4j.comparator;

public class ListCompare {
    public int compare(String left, String right) {
        int result = 0;
        int size = Math.min(left.length(), right.length());
        for (int i = 0; i < size; i++) {
            result = Integer.compare(right.charAt(i), left.charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            if (right.length() < left.length()) {
                result = 1;
            }
            if (left.length() < right.length()) {
                result = -1;
            }
        }
        return result;
    }
}