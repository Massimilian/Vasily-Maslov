package ru.job4j.homeworks;

//11.180. Известно, что в массиве имеются элементы, равные 5. Определить:
//        а) номер первого из них;
//        б) номер последнего из них.
//        В обеих задачах условный оператор не использовать.


public class Task11180 {
    public String findAll(int[] array, int point) {
        int[] numbers = new int[2];
        int count = 0;
        int notAResult = point == Integer.MAX_VALUE ? -1 : point + 1;
        do {
            numbers[0] = array[count++] == point ? count : notAResult;
        } while (numbers[0] == notAResult && count != array.length);
        count = array.length;
        do {
            numbers[1] = array[--count] == point ? ++count : notAResult;
        } while (numbers[1] == notAResult && count != 0);
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] == notAResult ? 0 : numbers[i];
        }
        return String.format("Минимальная позиция = %d, максимальная позиция = %d.", numbers[0], numbers[1]);
    }
}
