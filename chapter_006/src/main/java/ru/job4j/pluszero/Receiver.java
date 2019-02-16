package ru.job4j.pluszero;

import java.util.Random;
import java.util.Scanner;

/**
 * Class to receive the points and return the position
 */

public class Receiver {
    private Scanner scanner = new Scanner(System.in);

    public int[] answer() {
        int[] result = new int[2];
        System.out.println("Enter position X");
        result[0] = scanner.nextInt();
        System.out.println("Enter position Y");
        result[1] = scanner.nextInt();
        return result;
    }

    public int[] answer(int size) {
        Random random = new Random();
        int[] result = new int[2];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(size) + 1;
        }
        return result;
    }
}
