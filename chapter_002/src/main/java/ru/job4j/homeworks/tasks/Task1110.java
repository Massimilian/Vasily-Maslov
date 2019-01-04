package ru.job4j.homeworks.tasks;

//11.10. Дано натуральное число n (n < 999999). Заполнить массив его цифрами, расположенными в обратном порядке
//        (первый элемент равен последней цифре, второй — предпоследней и т. д.).
//        Незаполненные элементы массива должны быть равны нулю.
//        Элементы массива, являющиеся цифрами числа n, вывести на экран.

public class Task1110 {
    public int[] makeArray(int number) {
        int point = 10;
        //int[] result = new int[Integer.toString(number).length()];
        // вариант для неизвестного по размеру числа, более обощённый, без заполнения нолями
        int[] result = new int[6];
        for (int i = 0; i < result.length; i++) {
            result[i] = number % point;
            number = number / 10;
        }
        return result;
    }

    public String[] makeStringArray(int number) {
        String strNumber = Integer.toString(number);
        //String[] result = new int[strNumber.length()];
        // вариант для неизвестного по размеру числа, более обощённый, без заполнения нолями
        String[] result = new String[6];
        for (int i = strNumber.length() - 1; i >= 0; i--) {
            result[i] = String.valueOf(strNumber.charAt(strNumber.length() - 1 - i));
        }
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] == null) {
                result[i] = "0";
//            } else {
//                break;
            }
        }
        return result;
    }
}
