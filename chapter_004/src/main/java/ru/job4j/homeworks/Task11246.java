package ru.job4j.homeworks;

//11.246. Даны два массива одного размера. Получить третий массив, каждый элемент которого равен:
//        а) сумме элементов с тем же номером в заданных массивах;
//        б) произведению элементов с тем же номером в заданных массивах;
//        в) максимальному из элементов с тем же номером в заданных массивах.

import java.util.ArrayList;
import java.util.Iterator;

public class Task11246 {
    public int[] sum(int[] firstArray, int[] secondArray) {
        int[] result = new int[firstArray.length];
        if (firstArray.length == secondArray.length) {
            for (int i = 0; i < firstArray.length; i++) {
                result[i] = firstArray[i] + secondArray[i];
            }
        }
        return result;
    }

    public int[] theResult(int[] firstArray, int[] secondArray) {
        int[] result = new int[firstArray.length];
        if (firstArray.length == secondArray.length) {
            for (int i = 0; i < firstArray.length; i++) {
                result[i] = firstArray[i] * secondArray[i];
            }
        }
        return result;
    }

    public int[] max(int[] firstArray, int[] secondArray) {
        int[] result = new int[firstArray.length];
        if (firstArray.length == secondArray.length) {
            for (int i = 0; i < firstArray.length; i++) {
                result[i] = Math.max(firstArray[i], secondArray[i]);
            }
        }
        return result;
    }

    public ArrayList<Integer> sum(ArrayList<Integer> listOne, ArrayList<Integer> listTwo) {
        if (listOne.size() == listTwo.size()) {
            Iterator<Integer> itOne = listOne.iterator();
            Iterator<Integer> itTwo = listTwo.iterator();
            for (int i = 0; i < listOne.size(); i++) {
                listOne.set(i, itOne.next() + itTwo.next());
            }
        }
        return listOne;
    }

    public ArrayList<Integer> theResult(ArrayList<Integer> listOne, ArrayList<Integer> listTwo) {
        if (listOne.size() == listTwo.size()) {
            Iterator<Integer> itOne = listOne.iterator();
            Iterator<Integer> itTwo = listTwo.iterator();
            for (int i = 0; i < listOne.size(); i++) {
                listOne.set(i, itOne.next() * itTwo.next());
            }
        }
        return listOne;
    }


    public ArrayList<Integer> max(ArrayList<Integer> listOne, ArrayList<Integer> listTwo) {
        if (listOne.size() == listTwo.size()) {
            Iterator<Integer> itOne = listOne.iterator();
            Iterator<Integer> itTwo = listTwo.iterator();
            for (int i = 0; i < listOne.size(); i++) {
                listOne.set(i, Math.max(itOne.next(), itTwo.next()));
            }
        }
        return listOne;
    }
}
