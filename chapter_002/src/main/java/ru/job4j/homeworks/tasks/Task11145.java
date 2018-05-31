package ru.job4j.homeworks.tasks;

//11.145. Дан массив из четного числа элементов. Поменять местами:
//        а) его половины;
//        б) первый элемент со вторым, третий — с четвертым и т. д.;
//        в) его половины следующим способом: первый элемент поменять с последним, второй — с предпоследним и т. д.


public class Task11145 {
    public int[] halfChange(int[] array) {
        int[] result = new int[array.length];
        int count = array.length / 2;
        for (int i = 0; i < result.length; i++) {
            result[i] = array[count++];
            if (count == array.length) {
                count = 0;
            }
        }
        return result;
    }

    public int[] numbersMix(int[] array) {
        for (int i = 1; i < array.length; i = i + 2) {
            array[i] = array[i] + array[i - 1];
            array[i - 1] = array[i] - array[i - 1];
            array[i] = array[i] - array[i - 1];
        }
        return array;
    }

    public int[] turnArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            array[i] = array[i] + array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i] - array[array.length - 1 - i];
            array[i] = array[i] - array[array.length - 1 - i];
        }
        return array;
    }
}
