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
        // для первого коммита
        // для второго коммита
        // для третьего коммита
        System.out.println(tree);
    }
}
