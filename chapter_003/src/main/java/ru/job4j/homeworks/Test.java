package ru.job4j.homeworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        TreeMap<Integer, List<Integer>> tree = new TreeMap<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(0));
        tree.put(0, list);
//        tree.put(1, 10);
//        tree.put(2, 20);
//        tree.put(2, 30);
//        tree.putIfAbsent(3, 30);
//        tree.putIfAbsent(4, 40);
        System.out.println(tree);
    }
}
