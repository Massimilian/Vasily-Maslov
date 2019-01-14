package ru.job4j.compositecalc;

import ru.job4j.calculator.SubZeroMultipleException;

public class MainComposeCalc {
    public static void main(String[] args) throws SubZeroMultipleException {
        CalculatorManager cm = new CalculatorManager();
        Responder resp = new Responder();
        double tempRes = resp.numberAsk();
        do {
            tempRes = cm.working(tempRes, resp.operationAsk(), resp.numberAsk());
            System.out.printf("Result: %f%s", tempRes, System.lineSeparator());
        } while (!resp.exitProgram());
    }
}
