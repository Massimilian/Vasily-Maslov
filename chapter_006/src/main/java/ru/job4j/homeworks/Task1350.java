package ru.job4j.homeworks;

//13.50 Известно количество очков, набранных каждой из 19 команд-участниц пер-венства по футболу.
//Перечень очков и команд дан в порядке занятых ими мест,
//т. е. в порядке убывания количества набранных очков
//(ни одна пара команд-участниц не набрала одинаковое количество очков).
//Выяснилось, что в перечень забыли включить еще одну, двадцатую, команду.
//Получить новый список команд (с учетом дополнительной команды),
//в котором команды также расположены в порядке убывания количества набранных ими очков.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Task1350 {
    /*
    Main method for adding new position.
     */
    public TreeMap<String, Integer> insert(TreeMap<String, Integer> commands, String name, int number) {
        commands.put(name, number);
        return this.sort(commands);
    }

    /*
    Private method for sorting HashMap through the Stream()
     */
    private TreeMap<String, Integer> sort(TreeMap<String, Integer> forSort) {
        TreeMap<String, Integer> result = new TreeMap<String, Integer>();
        for (String s : new ArrayList<>(forSort.keySet()).stream().sorted().collect(Collectors.toList())) {
            result.put(s, forSort.get(s));
        }
        return result;
    }
}
