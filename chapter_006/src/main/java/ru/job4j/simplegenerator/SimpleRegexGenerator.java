package ru.job4j.simplegenerator;

// Генератор с использованием Regex

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegexGenerator extends SimpleGenerator {

    public SimpleRegexGenerator() {
        this.map = new HashMap<String, String>();
    }

    public String generate(String enter) {
        Pattern pattern = Pattern.compile("\\$\\{.+?\\}");
        Matcher matcher = pattern.matcher(enter);
        while (matcher.find()) {
            // Зачем компилятор потребовал добавления CharSequence? Ведь метод map.get() в любом случае вернёт String.
            enter = enter.replace(matcher.group(), (CharSequence) map.get(matcher.group()));
        }
        return enter;
    }
}
