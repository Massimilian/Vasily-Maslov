package ru.job4j.homeworks;

//11.167. Вставить число a в массив целых чисел после всех элементов, в которых есть цифра 5.
//        Каким должен быть максимальный размер исходного массива?

public class Task11167 {
    public int[] putNumber(int[] array, int a) {
        String[] strArray = new String[array.length * 2];
        String aStr = String.valueOf(a);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            String str = String.valueOf(array[i]);
            strArray[count++] = str;
            if (str.contains("5")) {
                strArray[count++] = aStr;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(strArray[i]);
        }
        return result;
    }
}
