package ru.job4j.homeworks.simpletasks;

//Задан одномерный массив. Нужно найти все возможные варианты перестановок этого массива.

public class Task20 {
    public int[][] rechanges(int[] array) {
        int[][] result = {{array[0]}};
        for (int i = 1; i < array.length; i++) {
            int numberToAdd = array[i];
            int size = i + 1;
            result = universal(result, numberToAdd, size);
        }
        return result;
    }

    private int[][] universal(int[][] ordinalMass, int toPaste, int leng) {
        int[][] newMass = new int[this.fact(leng)][leng];
        int count = 0;
        int theArray = 0;
        int changerOfSecondCount = 0;
        for (int i = 0; i < newMass.length; i++) {
            boolean isPasted = false;
            for (int j = 0; j < newMass[i].length; j++) {
                if (isPasted) {
                    newMass[i][j] = ordinalMass[theArray][j - 1];
                } else {
                    if (count == j) {
                        count++;
                        newMass[i][j] = toPaste;
                        isPasted = true;
                    } else {
                        newMass[i][j] = ordinalMass[theArray][j];
                    }
                }
            }
            changerOfSecondCount++;
            if (changerOfSecondCount - 1 == ordinalMass[0].length) {
                theArray++;
                changerOfSecondCount = 0;
                count = 0;
            }
        }
        return newMass;
    }

    private int fact(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
