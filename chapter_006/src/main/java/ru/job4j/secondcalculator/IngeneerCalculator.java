package ru.job4j.secondcalculator;

import ru.job4j.secondcalculator.operations.*;

import java.util.ArrayList;

/**
 * The small addition to the SimpleCalculator
 */
public class IngeneerCalculator {
    private ArrayList<Operation> operations = new ArrayList<>();

    public IngeneerCalculator() {
        operations.add(new Percent("%"));
        operations.add(new Pow("pow"));
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }
}
