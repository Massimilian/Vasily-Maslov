package ru.job4j.homeworks.task12282;

//12.282. Проверить, одинаковые ли строки массива с номерами n1 и n2?

public class Task12282 {
    public boolean testing(char[][] array, int one, int two) {
        boolean equality = true;
        if (array[one].length == array[two].length) {
            for (int i = 0; i < array[one].length; i++) {
                if (array[one][i] != array[two][i]) {
                    equality = false;
                    break;
                }
            }
        } else {
            equality = false;
        }
        return equality;
    }
}
