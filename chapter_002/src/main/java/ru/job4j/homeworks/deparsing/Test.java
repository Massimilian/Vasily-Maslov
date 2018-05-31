package ru.job4j.homeworks.deparsing;

public class Test {
    public static void main(String[] args) {
        DeparsingEasy dep = new DeparsingEasy();
        int[][] u = dep.deparse("[{[([])]}][]]");
        System.out.println(u);
    }
}
