package ru.job4j.homeworks.tasks;

//11.159. Вставить в массив:
//        а) число 10 после второго элемента;
//        б) число 100 после m-го элемента.

public class Task11159 {
    public int[] enterNumbers(int[] array, int number, int frequency) {
        int[] result;
        if (frequency <= 1) {
            System.out.println("Check frequency!");
            result = array;
        } else {
            result = new int[array.length + array.length / frequency];
            int count = 0;
            int correction = 0;
            for (int i = 0; i < result.length; i++) {
                if (count != frequency) {
                    count++;
                    result[i] = array[i - correction];
                } else {
                    count = 0;
                    result[i] = number;
                    correction++;
                }
            }
        }
        return result;
    }
}
