package ru.job4j.calculator;

import java.util.Scanner;

public class InteractCalc extends Calculator {

    /**
     * First number for operation.
     */
    private double first = 0;

    /**
     * Second number for operation.
     */
    private double second = 0;

    /**
     * Special param for choosing operation
     */
    private String type = "";

    /**
     * Scanner for reading numbers.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * checking the zero dividing
     *
     * @param first
     * @param second
     * @throws SubZeroMultipleException
     */
    @Override
    public void div(double first, double second) throws SubZeroMultipleException {
        if ((int) this.second == 0) {
            throw new SubZeroMultipleException("Impossible action!");
        } else {
            super.div(first, second);
        }
    }

    /**
     * Method for scanning first number from user.
     */
    public void operationFirst() {
        System.out.println("Enter first number:");
        this.first = scanner.nextDouble();
    }

    /**
     * Method for scanning second number from user.
     */
    public void operationSecond() {
        System.out.println("Enter second number:");
        this.second = scanner.nextDouble();
    }

    /**
     * Method for choosing the operation
     */
    public void choosing() {
        System.out.printf("Enter the type of operation: (+, -, *, /).");
        this.type = scanner.next();
    }

    /**
     * Choosing the main operation
     *
     * @throws OperationException
     * @throws SubZeroMultipleException
     */
    public void calc() throws OperationException, SubZeroMultipleException {
        if (this.type.equals("+")) {
            add(this.first, this.second);
        } else if (this.type.equals("-")) {
            subtrack(this.first, this.second);
        } else if (this.type.equals("*")) {
            multiple(this.first, this.second);
        } else if (this.type.equals("/")) {
            div(this.first, this.second);
        } else {
            throw new OperationException("Impossible operation!");
        }
    }

    /**
     * Try to exit
     *
     * @return true if need to exit.
     */
    public boolean exit() {
        System.out.println("Exit (y/n)?");
        if (scanner.next().equals("y")) {
            return true;
        } else {
            this.first = getResult();
            return false;
        }
    }
}
