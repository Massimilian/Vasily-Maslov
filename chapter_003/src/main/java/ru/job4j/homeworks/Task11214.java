package ru.job4j.homeworks;

//11.214. Фирме принадлежат два магазина.
//        Известна стоимость товаров, проданных в каждом магазине за каждый день в июле и августе,
//        которая хранится в двух массивах.
//        Получить общую стоимость проданных фирмой товаров за два месяца.


import java.util.Iterator;
import java.util.List;

public class Task11214 {
    public int sumOfSellings(int[] oneShop, int[] twoShop) {
        return sumOfArray(oneShop) + sumOfArray(twoShop);
    }

    private int sumOfArray(int[] month) {
        int res = 0;
        for (int i = 0; i < month.length; i++) {
            res += month[i];
        }
        return res;
    }

    public int sumOfSellings(List<Integer> oneShop, List<Integer> twoShop) {
        return sumOfArray(oneShop) + sumOfArray(twoShop);
    }

    private int sumOfArray(List<Integer> shop) {
        int res = 0;
        Iterator it = shop.iterator();
        while (it.hasNext()) {
            res += (int) it.next();
        }
        return res;
    }

}
