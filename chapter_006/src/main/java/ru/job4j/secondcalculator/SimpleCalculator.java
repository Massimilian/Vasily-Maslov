package ru.job4j.secondcalculator;

import ru.job4j.secondcalculator.operations.*;

import java.util.ArrayList;

/**
 * Main class with composed IngeneerCalculator
 */
public class SimpleCalculator {
    private IngeneerCalculator ic;
    private double first;
    private double second;
    private String oper;
    private boolean isExit;
    private boolean unSupported = false;
    private ArrayList<Operation> operations = new ArrayList<>();
    private StringBuilder protocol = new StringBuilder();
    private ClientAsk ca = new ClientAsk();

    public SimpleCalculator() {
        operations.add(new Add("+"));
        operations.add(new Divide(":"));
        operations.add(new Multiply("*"));
        operations.add(new Subtract("-"));
        ic = new IngeneerCalculator();
        for (int i = 0; i < ic.getOperations().size(); i++) {
            operations.add(ic.getOperations().get(i));
        }
        ic = null;
    }

    /**
     * Main method to start calculatings
     */
    public void action() {
        this.first = getNumber();
        this.protocol.append(String.format("%f ", first));
        getOper();
        while (!isExit) {
            this.second = getNumber();
            writing();
            function();
            getOper();
        }
        System.out.print(protocol);
    }

    /**
     * Method for getting type of operations and checking its work capacity
     */
    private void getOper() {
        do {
            oper = ca.ask("Enter the type of operation");
            check();
        } while (this.unSupported);
    }

    /**
     * Method for receiving number and checking is it really number
     *
     * @return result of operation work
     */
    private double getNumber() {
        double result;
        try {
            result = Double.valueOf(ca.ask("Enter the number."));
        } catch (NumberFormatException nfe) {
            System.out.println("You haven't entered a number!");
            result = getNumber();
        }
        return result;
    }

    /**
     * Method for check the operation possibility
     */
    private void check() {
        unSupported = true;
        for (int i = 0; i < operations.size(); i++) {
            if (oper.equals(operations.get(i).getSign())) {
                unSupported = false;
                break;
            }
            if (this.oper.equals("=")) {
                this.isExit = true;
                unSupported = false;
                protocol.append(String.format("%s %f", oper, first));
                break;
            }
        }
        if (unSupported) {
            System.out.println("Unknown operation!");
        }
    }

    /**
     * Method for preparing the protocol of working actions
     */
    private void writing() {
        this.protocol.append(String.format("%s %f ", oper, second));
    }

    /**
     * Method to activate the choosed operation
     */
    private void function() {
        for (int i = 0; i < operations.size(); i++) {
            if (this.oper.equals(operations.get(i).getSign())) {
                this.first = operations.get(i).function(this.first, this.second);
            }
        }
    }
}
