package ru.job4j.compositecalc;

import ru.job4j.calculator.SubZeroMultipleException;

public class CalculatorManager {
    CalculatorForComposite cfc = new CalculatorForComposite();
    EngennerCalculatorForComposite ecfc = new EngennerCalculatorForComposite();


    public double working(double first, String operation, double second) throws SubZeroMultipleException {
        double result = 0.0;
        switch (operation) {
            case ("+"):
                result = cfc.add(first, second);
                break;
            case ("-"):
                result = cfc.subtrack(first, second);
                break;
            case ("*"):
                result = cfc.multiple(first, second);
                break;
            case (":"):
                result = cfc.div(first, second);
                break;
            default:
                switch (operation) {
                    case ("%"):
                        result = ecfc.percent(first, second);
                        break;
                    case ("^"):
                        result = ecfc.pow(first, second);
                        break;
                    default:
                        System.out.println("Unknown operation");
                        result = first;
                }
        }
        return result;
    }
}
