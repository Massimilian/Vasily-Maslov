package ru.job4j.homeworks.tasks;

//11.155. В массиве записана информация о росте каждого из 25 учеников класса (в порядке убывания роста).
//        Из класса выбыли два ученика. Получить новый массив с упорядоченными в том же порядке данными о росте оставшихся учеников.
//        Рассмотреть два возможных случая:
//        1) известны порядковые номера выбывших учеников;
//        2) известны значения роста выбывших учеников.

public class Task11155 {
    public int[] deleteTwoPupilsByHeight(int[] array, int first, int second) {
        int[] result = new int[array.length - 2];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first || array[i] == second) {
                count++;
                continue;
            }
            result[i - count] = array[i];
        }
        return result;
    }

    public int[] deleteTwoPupilsByCount(int[] array, int first, int second) {
        int[] result = new int[array.length - 2];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == first - 1 || i == second - 1) {
                count++;
                continue;
            }
            result[i - count] = array[i];
        }
        return result;
    }

    // то же самое для рандомного количества учеников
    public int[] deleteRandomNumberOfPupilsByHeight(int[] array, int[] pupils) {
        int[] result;
        if (array.length < pupils.length) {
            System.out.println("Error! Too many pupils for exit!");
            result = new int[]{};
        } else {
            result = new int[array.length - pupils.length];
            int count = 0;
            boolean isCrossed = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < pupils.length; j++) {
                    if (array[i] == pupils[j]) {
                        isCrossed = true;
                        break;
                    }
                }
                if (isCrossed) {
                    count++;
                    isCrossed = false;
                } else {
                    result[i - count] = array[i];
                }
            }
        }
        return result;
    }
}
