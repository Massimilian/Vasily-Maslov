package ru.job4j.homeworks;

//11.189.*Для арифметических операций с большими числами, которые не могут быть
//        представлены в памяти компьютера, используется следующий прием. Каждая
//        цифра таких чисел записывается в отдельный элемент массива, и необходимые
//        операции проводятся с элементами массива цифр. Составить программу:
//        а) выполняющую сложение 20-значных чисел;
//        б) выполняющую вычитание 30-значных чисел;

public class Task11189 {
    public String bigSumAndDifference(String first, String second, String value) {
        StringBuilder result = new StringBuilder();
        boolean minus = false;
        if (!value.equals("+") && !value.equals("-")) {
            result = new StringBuilder("ERROR!");
        } else if (this.theBiggest(second, first) && value.equals("-")) {
            result = new StringBuilder(this.bigSumAndDifference(second, first, value));
            minus = true;
        } else if (first.charAt(0) == '-') {
            first = first.substring(1);
            if (value.equals("+")) {
                result = new StringBuilder(this.bigSumAndDifference(second, first, "-"));
            } else {
                result = new StringBuilder(this.bigSumAndDifference(second, first, "+"));
                minus = true;
            }
        } else if (second.charAt(0) == '-') {
            second = second.substring(1);
            if (value.equals("+")) {
                result = new StringBuilder(this.bigSumAndDifference(second, first, "-"));
                minus = true;
            } else {
                result = new StringBuilder(this.bigSumAndDifference(second, first, "+"));
            }
        } else {
            int count = 0;
            if (first.length() != second.length()) {
                int diff = Math.abs(first.length() - second.length());
                if (first.length() > second.length()) {
                    second = this.redString(second, diff);
                } else {
                    first = this.redString(first, diff);
                }
            }
            if (value.equals("+")) {
                for (int i = first.length() - 1; i >= 0; i--) {
                    int res = Character.getNumericValue(first.charAt(i)) + Character.getNumericValue(second.charAt(i)) + count;
                    count = res >= 10 ? 1 : 0;
                    res = res >= 10 ? res - 10 : res;
                    result.insert(0, Integer.toString(res));
                }
                result = new StringBuilder(count == 1 ? Integer.toString(count) + result : result.toString());
            }
            if (value.equals("-")) {
                for (int i = first.length() - 1; i >= 0; i--) {
                    int res = 10 + Character.getNumericValue(first.charAt(i)) - Character.getNumericValue(second.charAt(i)) - count;
                    count = res < 10 ? 1 : 0;
                    res = res >= 10 ? res - 10 : res;
                    result.insert(0, Integer.toString(res));

                }
                while (result.charAt(0) == '0' && result.length() != 1) {
                    result = new StringBuilder(result.substring(1));
                }
            }
            minus = first.charAt(0) == '-' && second.charAt(0) == '-' ? true : false;
        }
        if (minus && !result.toString().equals("0")) {
            result = new StringBuilder(result.charAt(0) == '-' ? result.substring(1) : "-" + result);
        }
        return result.toString();
    }

    private String redString(String s, int diff) {
        for (int i = 0; i < diff; i++) {
            s = "0" + s;
        }
        return s;
    }

    private boolean theBiggest(String first, String second) {
        boolean result = first.length() > second.length() ? true : false;
        if (first.length() == second.length()) {
            for (int i = 0; i < second.length(); i++) {
                if (Character.getNumericValue(first.charAt(i)) > Character.getNumericValue(second.charAt(i))) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
