package ru.job4j.homeworks.simpletasks;

// Реализован банкомат размена денег.
// Автомат принимает бумажную купюру и обменивает на монеты.
// Метод должен возвращать список всех возможных вариантов размены купюры.

import java.util.ArrayList;
import java.util.Arrays;

public class Task17 {
    private ArrayList<Integer> monetas = new ArrayList<>(Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200));
    private String ls = System.lineSeparator();

    public ArrayList<String> change(double money) {
        String res = "";
        double mon = money * 100;
        ArrayList<String> result = new ArrayList<>();
        this.universal(result, mon, res, this.monetas.size() - 1);
        return result;
    }


    private void ones(ArrayList<String> result, double mon, String res) {
        int count = 1;
        if (mon >= 0) {
            res = String.format("%s%d cent - %d.", res, count, (int) mon);
            result.add(res);
        }
    }


    private void universal(ArrayList<String> result, double mon, String res, int point) {
        int count = monetas.get(point);
        String tempRes = res;
        int remain = (int) mon / count + 1;
        if (mon >= 0) {
            for (int i = 0; i < remain; i++) {
                if (count == 100) {
                    tempRes = String.format("%s%d dollar - %d.%s", tempRes, count / 100, i, this.ls);
                } else if (count >= 200) {
                    tempRes = String.format("%s%d dollars - %d.%s", tempRes, count / 100, i, this.ls);
                } else {
                    tempRes = String.format("%s%d cent - %d.%s", tempRes, count, i, this.ls);
                }
                if (point == 1) {
                    this.ones(result, mon, tempRes);
                    mon = mon - count;
                    tempRes = res;
                } else {
                    this.universal(result, mon, tempRes, point - 1);
                    mon = mon - count;
                    tempRes = res;
                }
            }
        }
    }
}
