package ru.job4j.arrayconvert;

import java.util.ArrayList;
import java.util.List;

public class ConvertListToArray {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] array = new int[cells][rows];
        int count = 0;
        for (int i = 0; i < cells; i++) {
            for (int j = 0; j < rows; j++) {
                if (count < list.size()) {
                    array[i][j] = list.get(count);
                    count++;
                } else {
                    break;
                }
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] counts : list) {
            for (int i : counts) {
                result.add(i);
            }
        }
        return result;
    }
}
