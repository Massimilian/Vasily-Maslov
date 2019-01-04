package ru.job4j.calculator;

public class EngeneerCalc extends InteractCalc {

    /**
     * Choosing the main operation.
     *
     * @throws OperationException
     * @throws SubZeroMultipleException
     */
    @Override
    public void calc() throws OperationException, SubZeroMultipleException {
        if (getType().equals("+")) {
            add(getFirst(), getSecond());
        } else if (getType().equals("-")) {
            subtrack(getFirst(), getSecond());
        } else if (getType().equals("*")) {
            multiple(getFirst(), getSecond());
        } else if (getType().equals("/")) {
            div(getFirst(), getSecond());
        } else if (getType().equals("pow")) {
            pow(getFirst(), getSecond());
        } else if (getType().equals("%")) {
            percent(getFirst(), getSecond());
        } else {
            throw new OperationException("Impossible operation!");
        }
    }

    /**
     * Find percent.
     *
     * @param first  - number.
     * @param second - number of percents.
     */
    private void percent(double first, double second) {
        setResult(first / 100 * second);
    }

    /**
     * Make pow operation.
     *
     * @param first
     * @param second
     */
    private void pow(double first, double second) {
        setResult(Math.pow(first, second));
    }

    /**
     * Method for choosing the operation.
     */
    public void choosing() {
        System.out.println("Enter the type of operation: (+, -, *, /, pow, %).");
        setType(getScanner().next());
    }
}
