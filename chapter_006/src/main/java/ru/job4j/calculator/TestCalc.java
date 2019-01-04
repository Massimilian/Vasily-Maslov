package ru.job4j.calculator;

/**
 * Special class for tests.
 */
public class TestCalc extends EngeneerCalc {
    /**
     * Special position for automatic asks.
     */
    String[] asks = new String[]{};
    int position = 0;

    public void setAsks(String[] asks) {
        this.asks = asks;
    }

    /**
     * Overrode method for automatic asks.
     */
    @Override
    public void operationFirst() {
        setFirst(Double.parseDouble(asks[position++]));
    }

    /**
     * Overrode method for automatic asks.
     */
    @Override
    public void operationSecond() {
        setSecond(Double.parseDouble(asks[position++]));
    }

    /**
     * Overrode method for automatic asks.
     */
    @Override
    public void choosing() {
        setType(asks[position++]);
    }
}
