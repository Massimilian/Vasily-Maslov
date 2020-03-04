package ru.job4j.homeworks;
//13.51.* Известно количество очков, набранных каждой из 20 команд-участниц пер-венства по футболу.
//        Ни одна пара команд не набрала одинаковое количество очков.
//        Вывести названия команд в соответствии с занятыми ими местами в чемпионате.

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Task1351 {
    public String commandName(Map<String, Integer> commands, int number) {
        String result = "Unknown mistake";
        if (number > commands.size()) {
            result = "There's no any command.";
        } else {
            ArrayList<Integer> sorted = (ArrayList<Integer>) commands.values().stream().sorted().collect(Collectors.toList());
            int asked = sorted.get(sorted.size() - number);
            for (Map.Entry<String, Integer> entry : commands.entrySet()) {
                if (entry.getValue() == asked) {
                    result = entry.getKey();
                    break;
                }
            }
        }
        return result;
    }
}
