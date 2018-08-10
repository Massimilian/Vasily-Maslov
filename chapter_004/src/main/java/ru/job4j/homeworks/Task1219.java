package ru.job4j.homeworks;

//12.19. Составить программу:
//        а) сравнения по абсолютной величине элемента, расположенного в верхнем правом углу двумерного массива,
//        с любым другим элементом массива (определить, какая из абсолютных величин больше);
//        б) сравнения двух любых элементов массива (определить, какой из них меньше).

public class Task1219 {
    public boolean isMax(int[][] doubleArray) {
        boolean result = true;
        int max = doubleArray[0][doubleArray[0].length - 1];
        for (int i = 0; i < doubleArray.length; i++) {
            if (!result) {
                break;
            }
            for (int j = 0; j < doubleArray[i].length; j++) {
                if (doubleArray[i][j] > max) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public boolean isBigger(int[][] doubleArray, int firstY, int firstX, int secondY, int secondX) {
        boolean result = true;
        if (firstX > doubleArray[firstY].length - 1 || secondX > doubleArray[secondY].length - 1 || secondY > doubleArray.length || firstY > doubleArray.length) {
            System.out.println("Enter correct numbers!");
        } else {
            int result1 = doubleArray[firstY][firstX];
            int result2 = doubleArray[secondY][secondX];
            result = result1 > result2;
        }
        return result;
    }
}
