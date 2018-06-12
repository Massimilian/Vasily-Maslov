package ru.job4j.arrayconvert;

import java.util.ArrayList;
import java.util.List;

public class ConvertArrayToList {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }
}
