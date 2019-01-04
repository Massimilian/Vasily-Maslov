package ru.job4j.calculator;

public class MainCalculator {
    public static void main(String[] args) {
        EngeneerCalc calc = new EngeneerCalc();
        calc.operationFirst();
        calc.choosing();
        while (!calc.getExit()) {
            calc.operationSecond();
            try {
                calc.calc();
            } catch (OperationException oe) {
                oe.printStackTrace();
            } catch (SubZeroMultipleException szme) {
                szme.printStackTrace();
            }
            System.out.println(calc.getResult());
            calc.choosing();
        }
        System.out.println(calc.getOperations());
    }
}
