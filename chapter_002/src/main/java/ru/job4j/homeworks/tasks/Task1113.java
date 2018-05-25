package ru.job4j.homeworks.tasks;

//11.13. Составить программу вывода на экран любого элемента массива по его ин-дексу.

public class Task1113 {
    public void arr(double[] arr, int count) {
        if (count > arr.length - 1) {
            System.out.println("Out of bounds!");
        }
        System.out.println(arr[count + 1]);
    }

    public void arr(String[] arr, int count) {
        if (count > arr.length - 1) {
            System.out.println("Out of bounds!");
        }
        System.out.println(arr[count + 1]);
    }

    public void arr(char[] arr, int count) {
        if (count > arr.length - 1) {
            System.out.println("Out of bounds!");
        }
        System.out.println(arr[count + 1]);
    }

    public void arr(long[] arr, int count) {
        if (count > arr.length - 1) {
            System.out.println("Out of bounds!");
        }
        System.out.println(arr[count + 1]);
    }

    public void arr(int[] arr, int count) {
        if (count > arr.length - 1) {
            System.out.println("Out of bounds!");
        }
        System.out.println(arr[count + 1]);
    }

    public void arr(float[] arr, int count) {
        if (count > arr.length - 1) {
            System.out.println("Out of bounds!");
        }
        System.out.println(arr[count]);
    }

    public void arr(byte[] arr, int count) {
        if (count > arr.length - 1) {
            System.out.println("Out of bounds!");
        }
        System.out.println(arr[count]);
    }
}
