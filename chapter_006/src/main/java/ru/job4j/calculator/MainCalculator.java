package ru.job4j.calculator;

public class MainCalculator {
    public static void main(String[] args) {
        EngeneerCalc calc = new EngeneerCalc();
        calc.operationFirst();
        do {
            calc.operationSecond();
            calc.choosing();
            try {
                calc.calc();
            } catch (OperationException oe) {
                oe.printStackTrace();
            } catch (SubZeroMultipleException szme) {
                szme.printStackTrace();
            }
            System.out.println(calc.getResult());
        } while (!calc.exit());
    }
}
