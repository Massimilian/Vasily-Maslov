package ru.job4j.homeworks;

//12.275. В каждой строке массива найти количество букв е, расположенных справа
//        от буквы н (известно, что буква н в каждой строке единственная).

public class Task12275 {
    public int[] find(char[][] arr, char a, char z) {
        int[] result = new int[arr.length];
        int count;
        boolean was;
        for (int i = 0; i < arr.length; i++) {
            count = 0;
            was = false;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == a) {
                    was = true;
                }
                if (was && arr[i][j] == z) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
