package ru.job4j.nonblockingcash;

public class OptimisticException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Exception in optimization function.";
    }
}
