package ru.job4j.homeworks;

//11.168.*Вставить число n между всеми соседними элементами, имеющими одинаковый знак.
//        Каким должен быть максимальный размер исходного массива?

public class Task11168 {
    public int[] enterNumber(int[] array, int n) {
        int[] mediumResult = new int[array.length * 2 - 1];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                mediumResult[i + count] = array[i];
                count = array.length + count;
                break;
            }
            mediumResult[i + count] = array[i];
            if ((array[i] > 0 && array[i + 1] > 0 || array[i] < 0 && array[i + 1] < 0)) {
                mediumResult[i + ++count] = n;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = mediumResult[i];
        }
        return result;
    }
}
