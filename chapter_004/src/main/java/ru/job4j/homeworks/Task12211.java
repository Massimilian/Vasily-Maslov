package ru.job4j.homeworks;

//12.211. В каждой строке двумерного массива поменять местами первый нулевой элемент
//        и последний отрицательный. Если таких элементов нет,
//        то должно быть выведено соответствующее сообщение.

public class Task12211 {
    public int[][] changeZeroAndSubzero(int[][] array) {
        int zeroPlace;
        int subzeroPlace;
        boolean hasNoChanges = true;
        boolean changedZero;
        boolean changedSubzero;
        for (int i = 0; i < array.length; i++) {
            changedZero = false;
            changedSubzero = false;
            zeroPlace = 0;
            subzeroPlace = 0;
            for (int j = 0; j < array[i].length; j++) {
                if (!changedZero && array[i][j] == 0) {
                    zeroPlace = j;
                    changedZero = true;
                }
                if (array[i][j] < 0) {
                    subzeroPlace = j;
                    changedSubzero = true;
                }
            }
            if (changedZero && changedSubzero) {
                array[i][zeroPlace] += array[i][subzeroPlace];
                array[i][subzeroPlace] = array[i][zeroPlace] - array[i][subzeroPlace];
                array[i][zeroPlace] -= array[i][subzeroPlace];
                hasNoChanges = false;
            }
        }
        if (hasNoChanges) {
            System.out.println("There wasn't any changes!");
        }
        return array;
    }
}
