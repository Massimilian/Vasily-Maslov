package ru.job4j.homeworks.tasks;

//11.3. Заполнить массив из пятнадцати элементов случайным образом:
//        а) вещественными значениями, лежащими в диапазоне от 0 до 1;
//        б) вещественными значениями х (22 х < 23);
//        в) вещественными значениями х (0 х < 10);
//        г) вещественными значениями х (–50 х < 50);
//        д) целыми значениями, лежащими в диапазоне от 0 до 10 включительно.

import java.util.Random;

public class Task113 {
    Random random = new Random();

    public String[] method(String[] sub) {
        int change = random.nextInt(5);
        switch (change) {
            case 0:
                System.out.println("Отработал вариант №" + change);
                sub = this.newMethodZeroOneTwoThree(sub, 0, 0);
                break;
            case 1:
                System.out.println("Отработал вариант №" + change);
                sub = this.newMethodZeroOneTwoThree(sub, 0, 22);
                break;
            case 2:
                System.out.println("Отработал вариант №" + change);
                sub = this.newMethodZeroOneTwoThree(sub, 10, 0);
                break;
            case 3:
                System.out.println("Отработал вариант №" + change);
                sub = this.newMethodZeroOneTwoThree(sub, 100, -50);
                break;
            case 4:
                System.out.println("Отработал вариант №" + change);
                sub = this.newMethodFour(sub);
                break;
            default:
                System.out.println("Unknown error!");
                break;
        }
        return sub;
    }

    private String[] newMethodZeroOneTwoThree(String[] sub, int size, int position) {
        double[] array = new double[sub.length];
        if (size != 0) {
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextDouble() + random.nextInt(size) + position;
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextDouble() + position;
            }
        }

        for (int i = 0; i < sub.length; i++) {
            sub[i] = Double.toString(array[i]);
        }
        return sub;
    }

    private String[] newMethodFour(String[] sub) {
        int[] array = new int[sub.length];
        for (int i = 0; i < sub.length; i++) {
            array[i] = random.nextInt(10);
        }
        for (int i = 0; i < sub.length; i++) {
            sub[i] = Integer.toString(array[i]);
        }
        return sub;
    }
}