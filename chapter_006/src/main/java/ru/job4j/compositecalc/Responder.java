package ru.job4j.compositecalc;

import java.util.Scanner;

public class Responder {
    private String number = "Please enter a number:";
    private String operation = "Please enter an operation type:";
    private String exit = "Exit this program(y)?";

    public double numberAsk() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(number);
        return scanner.nextDouble();
    }

    public String operationAsk() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(operation);
        return scanner.next();
    }


    public boolean exitProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(exit);
        return scanner.nextLine().equals("y");
    }


}
