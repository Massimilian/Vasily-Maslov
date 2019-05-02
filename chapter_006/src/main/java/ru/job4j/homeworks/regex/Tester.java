package ru.job4j.homeworks.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("Some");
        Matcher m = p.matcher("Some text and plus. How?");
        while (m.find()) {
            System.out.print(m.start() + " " + m.group() + System.lineSeparator());
        }
    }
}
