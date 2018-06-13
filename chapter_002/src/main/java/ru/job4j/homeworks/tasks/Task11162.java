package ru.job4j.homeworks.tasks;

//11.162. Данные о росте 15 юношей класса, упорядоченные по убыванию, записаны в массиве.
//        В начале учебного года в класс поступил новый ученик.
//        Получить аналогичный массив, учитывающий рост нового ученика.
//        Рассмотреть два возможных случая:
//        1) известен порядковый номер нового ученика;
//        2) известен рост нового ученика.

public class Task11162 {
    public int[] addNewPupil(int[] array, int height) {
        int[] result = new int[array.length + 1];
        boolean hasPut = false;
        for (int i = array.length - 1; i >= 0; i--) {
            if (!hasPut && height >= array[i]) {
                hasPut = true;
                result[i + 1] = height;
                result[i] = array[i];
                continue;
            }
            if (!hasPut) {
                result[i + 1] = array[i];
            } else {
                result[i] = array[i];
            }
        }
        result[0] = result[0] == 0 ? height : result[0];
        return result;
    }

    public int[] addNewPupilWithNumber(int[] array, int height, int position) {
        int[] result = new int[array.length + 1];
        int count = 0;
        position--;
        if (position < 0 || position > array.length) {
            System.out.println("Incorrect position!");
        } else {
            while (count < position) {
                result[count] = array[count];
                count++;
            }
            result[count] = height;
            count++;
            while (count < result.length) {
                result[count] = array[count - 1];
                count++;
            }
        }
        return result;
    }
}
