package ru.job4j.calculator;

import java.util.Scanner;

public class InteractCalc extends Calculator {

    /**
     * Special string to write all operations.
     */
    private String operations = "Result:";

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
     * Setter special for tests
     *
     * @param first
     */
    public void setFirst(double first) {
        this.first = first;
    }

    /**
     * Setter special for tests
     *
     * @param second
     */
    public void setSecond(double second) {
        this.second = second;
    }

    /**
     * Method for child class
     *
     * @return number
     */
    public double getFirst() {
        return first;
    }

    /**
     * Method for child class
     *
     * @return number
     */
    public double getSecond() {
        return second;
    }

    /**
     * Method for child class
     *
     * @return type of operation
     */
    public String getType() {
        return type;
    }

    /**
     * Method for child class
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Method for child class
     *
     * @return
     */
    public Scanner getScanner() {
        return scanner;
    }

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
        setOperations(String.valueOf(getFirst()));
    }

    /**
     * Method for scanning second number from user.
     */
    public void operationSecond() {
        System.out.println("Enter second number:");
        this.second = scanner.nextDouble();
        setOperations(String.valueOf(getSecond()));
    }

    /**
     * Method for choosing the operation
     */
    public void choosing() {
        System.out.println("Enter the type of operation: (+, -, *, /).");
        this.type = scanner.next();
        setOperations(this.type);
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
     * Special operation for renovation parameter 'first'.
     */
    public void renovation() {
        this.first = this.getResult();
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

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = String.format("%s %s", getOperations(), operations);
    }
}
