package ru.job4j.homeworks.simpletasks;

//        Реализовать класс Expression.
//        Класс должен принимать строку из просто математического выражения и методы double* calc().
//        Должен поддерживать операции + - / * exp.
//        Например, "2+2" - 4, "2-2" - 0
//        Если выражение не корректное выбросить исключение java.lang.IllegalStateException

//        Из-за особенностей класса double будет работать не совсем корректно c дробными данными. Здесь, кажется, надо использовать BigDecimal.


public class Task7 {
    private Task1 calculate = new Task1();
    private int action = 0;
    private double result = 0;
    private double secondNumber = 0;
    private String number = "";
    private String smallNumber = "";
    private boolean afterPoint = false;

    public double counting(String count) {
        for (int i = 0; i < count.length(); i++) {
            //отрабатываем все числа
            if (count.charAt(i) >= 48 && count.charAt(i) <= 57) {
                if (this.afterPoint) {
                    this.smallNumber += count.charAt(i);
                } else {
                    this.number += count.charAt(i);
                }
            } else
                // отрабатываем точку
                if (count.charAt(i) == 46 || count.charAt(i) == 44) {
                    if (this.afterPoint) {
                        throw new IllegalStateException();
                    }
                    this.afterPoint = true;
                } else

                    // отрабатываем пробел
                    if (count.charAt(i) == 32) {
                        continue;
                    } else
                        // отрабатываем равно
                        if (count.charAt(i) == 61) {
                            doSomething();
                        } else
                            // отрабатываем плюс
                            if (count.charAt(i) == 43) {
                                doSomething();
                                this.action = 1;
                            } else
                                // отрабатываем минус
                                if (count.charAt(i) == 45) {
                                    doSomething();
                                    this.action = 2;
                                } else
                                    // отрабатываем умножение
                                    if (count.charAt(i) == 42) {
                                        doSomething();
                                        this.action = 3;
                                    } else
                                        // отрабатываем умножение
                                        if (count.charAt(i) == 47) {
                                            doSomething();
                                            this.action = 4;
                                        } else
                                            // отрабатываем степень числа
                                            if (count.charAt(i) == 101) {
                                                doSomething();
                                                this.action = 5;
                                            } else {
                                                throw new UnsupportedOperationException("Cannot finish this operation.");
                                            }
        }
        return result;
    }

    private void writeNumber() {
        if (!this.smallNumber.equals("")) {
            this.secondNumber = Double.valueOf(this.number + "." + this.smallNumber);
        } else if (!this.number.equals("")) {
            this.secondNumber = Double.valueOf(this.number);
        }
        this.number = "";
        this.smallNumber = "";
        afterPoint = false;
    }

    private void doSomething() {
        this.writeNumber();
        if (this.action == 0) {
            this.result = this.secondNumber;
        }
        if (this.action == 1) {
            this.result = calculate.sum(this.result, this.secondNumber);
        }
        if (this.action == 2) {
            this.result = calculate.subtraction(this.result, this.secondNumber);
        }
        if (this.action == 3) {
            this.result = calculate.multiplication(this.result, this.secondNumber);
        }
        if (this.action == 4) {
            this.result = calculate.division(this.result, this.secondNumber);
        }
        if (this.action == 5) {
            this.result = calculate.pow(this.result, this.secondNumber);
        }
    }
}
