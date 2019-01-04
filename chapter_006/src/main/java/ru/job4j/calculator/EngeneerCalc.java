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
        if (getType().equals("pow")) {
            pow(getFirst(), getSecond());
        } else if (getType().equals("%")) {
            percent(getFirst(), getSecond());
        } else {
            super.calc();
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
        System.out.println("Enter the type of operation: (+, -, *, /, pow, %, =).");
        setType(getScanner().next());
        setOperations(this.getType());
        checkExit();
    }

    private void checkExit() {
        if (getType().equals("=")) {
            setOperations(String.valueOf(this.getResult()));
            setExit(true);
        }
    }
}
