package ru.job4j.homeworks.tasks;

//11.128. Какое число в массиве встретится раньше: максимальное или минимальное.
//        Если таких чисел несколько, то должны быть учтены самые первые из них.

public class Task11128 {
    public String earlyNumber(int[] array) {
        String answer;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minPlace = 0;
        int maxPlace = 0;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                minPlace = i;
            }
            if (max < array[i]) {
                max = array[i];
                maxPlace = i;
            }
        }
        if (minPlace < maxPlace) {
            answer = "Minimal number.";
        } else if (minPlace > maxPlace) {
            answer = "Maximal number.";
        } else {
            answer = "Minimal == Maximal.";
        }
        return answer;
    }
}
