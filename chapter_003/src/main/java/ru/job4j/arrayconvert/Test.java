package ru.job4j.arrayconvert;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ConvertListToArray clta = new ConvertListToArray();
        List<Integer> l = new ArrayList();
        for (int i = 0; i < 8; i++) {
            l.add(i);
        }
        int[][] arr = clta.toArray(l, 4);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
