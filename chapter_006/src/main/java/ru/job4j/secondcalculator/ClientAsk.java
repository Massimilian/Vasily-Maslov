package ru.job4j.secondcalculator;

import java.util.Scanner;

public class ClientAsk {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

}
