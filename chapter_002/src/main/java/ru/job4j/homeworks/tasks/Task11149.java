package ru.job4j.homeworks.tasks;

//Внимание!
//В задачах 11.149—11.158 под удалением элемента массива следует понимать:
//исключение этого элемента из массива путем смещения всех следующих за ним элементов влево на 1 позицию;
//присваивание последнему элементу массива значения 0.
//
//        11.149. Удалить из массива:
//        а) третий элемент;
//        б) k-й элемент.

public class Task11149 {
    public int[] delete(int[] array, int k) {
        int[] result = new int[array.length - 1];
        for (int i = 0; i < result.length; i++) {
            if (i >= k - 1) {
                result[i] = array[i + 1];
            } else {
                result[i] = array[i];
            }
        }
        return result;
    }
}
