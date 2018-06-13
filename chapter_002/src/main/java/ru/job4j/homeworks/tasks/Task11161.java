package ru.job4j.homeworks.tasks;

//11.161. В массив записали информацию о высоте над уровнем моря двадцати горных вершин мира.
//        Данные записаны в порядке,
//        соответствующем алфавитному порядку названий вершин.
//        После этого решили ввести в массив сведения еще по одной вершине.
//        Получить новый массив, имея в виду,
//        что место в массиве для записи дополнительной информации известно.

public class Task11161 {
    public int[] addMountain(int[] array, int mountain, int place) {
        int[] result = new int[array.length + 1];
        for (int i = 0; i <= array.length; i++) {
            if (place - 1 > i) {
                result[i] = array[i];
            } else if (place - 1 == i) {
                result[i] = mountain;
            } else {
                result[i] = array[i - 1];
            }
        }
        return result;
    }
}
