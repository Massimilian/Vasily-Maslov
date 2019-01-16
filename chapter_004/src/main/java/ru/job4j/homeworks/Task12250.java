package ru.job4j.homeworks;

import java.util.Scanner;


// в двумерный массив записали годовые оценки по десяти предметам
// за 9-й класс каждого из 25 учеников класса (в первой строчке - оценки первого ученика,
// во второй - второго и т.д.). В начале нового учебного года в класс пришел новый ученик.
// Изменить массив так, чтобы в нем были оценки за 9-ый класс и нового ученика, учитывая,
// что этот ученик в списке должен быть на n-ном месте. Оценки нового ученика вводятся с клавиатуры
// и в дополнительный массив записываться не должны.

public class Task12250 {
    // special methods for test
    int[] newPupil;

    public Task12250(int[] newPupil) {
        this.newPupil = newPupil;
    }

    public int[][] renovatePupils(int[][] array, int place) {
        //int[] newPupil = enterNewPupil(array[0].length);
        int[] newPupil = this.newPupil;
        int[][] result = new int[array.length + 1][array[0].length];
        boolean isPassed = false;
        int correct = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == place) {
                for (int j = 0; j < array[i].length; j++) {
                    result[i + correct][j] = newPupil[j];
                }
                correct++;
            }
            for (int j = 0; j < array[i].length; j++) {
                result[i + correct][j] = array[i][j];
            }
        }
        return result;
    }

    private int[] enterNewPupil(int size) {
        int[] result = new int[size];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            result[i] = scanner.nextInt();
        }
        return result;
    }
}
