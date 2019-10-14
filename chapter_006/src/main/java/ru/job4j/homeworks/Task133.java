package ru.job4j.homeworks;

//13.3. Даны названия 26 городов и стран, в которых они находятся. Среди них есть
//        города, находящиеся в Италии. Напечатать их названия.

import java.util.HashMap;
import java.util.Map;

public class Task133 {
    public HashMap<String, String> findTowns(String country, HashMap<String, String> map) {
        HashMap<String, String> result = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(country)) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}
