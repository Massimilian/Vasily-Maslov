package ru.job4j.crudservlet;

public class Color {
    private String[] colors = {"yellowgreen", "lightgreen"};
    private int num = 0;

    public String get() {
        String result = colors[num++];
        num = num == colors.length ? 0 : num;
        return result;
    }
}
