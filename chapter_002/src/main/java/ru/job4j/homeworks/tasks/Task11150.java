package ru.job4j.homeworks.tasks;

//11.150. В массиве записана информация о стоимости каждого из 20 видов товара, продаваемых фирмой.
//        С 1 января очередного года фирма прекращает продавать товар,
//        стоимость которого записана в n-м элементе массива.
//        Получить массив со стоимостью всех оставшихся видов товара.

public class Task11150 {
    public int[] minusGood(int[] array, int n) {
        int[] res = new int[array.length - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i >= n ? array[i] : array[i + 1];
        }
        return res;
    }
}
