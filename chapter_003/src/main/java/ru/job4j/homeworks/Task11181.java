package ru.job4j.homeworks;

//11.181. Известно, что в массиве имеются элементы, большие 65 530. Определить:
//        а) номер первого из них;
//        б) номер последнего из них.
//        В обеих задачах условный оператор не использовать.

public class Task11181 {
    public int[] findAllBigger(int[] array, int count) {
        int[] result = new int[2];
        int position = 0;
        int notANumber = count == Integer.MIN_VALUE ? count : count - 1;
        do {
            result[0] = array[position++] > count ? position : notANumber;
        } while (result[0] == notANumber && position != array.length);
        position = array.length - 1;
        do {
            result[1] = array[position--] > count ? position + 2 : notANumber;
        } while (result[0] == notANumber && position < 0);
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] == notANumber ? 0 : result[i];
        }
        return result;
    }
}
