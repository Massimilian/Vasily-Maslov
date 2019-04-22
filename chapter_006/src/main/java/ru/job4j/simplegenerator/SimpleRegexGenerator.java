package ru.job4j.simplegenerator;

// Генератор с использованием Regex

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegexGenerator extends SimpleGenerator {

    public SimpleRegexGenerator() {
        map = new HashMap<String, String>();
    }

    @Override
    public void addMapValue(ArrayList<String> values) {
        map.put(values.get(0), values.get(1));
    }

    @Override
    public void addMapValue(Map.Entry<String, String> entry) {
        map.put(entry.getKey(), entry.getValue());
    }

    @Override
    public String generate(String enter) {
        Pattern pattern;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            pattern = Pattern.compile("\\$\\{" + entry.getKey() + "\\}");
            Matcher matcher = pattern.matcher(enter);
            while (matcher.find()) {
                enter = enter.replace(String.format("%s%s%s", begin, entry.getKey(), end), entry.getValue());
            }
        }
        return enter;
    }
}
