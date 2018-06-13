package ru.job4j.homeworks.tasks;

//11.165. Вставить в массив два числа: первое со значением n перед всеми элементами,
//        большими n, и второе со значением m — после всех элементов, меньших m.
//        Каким должен быть максимальный размер исходного массива?

public class Task11165 {
    public int[] changed(int[] array, int n, int m) {
        int[] mediumResult = new int[array.length * 3];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > n) {
                mediumResult[i + count] = n;
                count++;
                mediumResult[i + count] = array[i];
            }
            if (array[i] < m) {
                mediumResult[i + count] = array[i];
                count++;
                mediumResult[i + count] = m;
            }
        }
        int[] result = new int[array.length + count];
        for (int i = 0; i < result.length; i++) {
            result[i] = mediumResult[i];
        }
        return result;
    }
}
