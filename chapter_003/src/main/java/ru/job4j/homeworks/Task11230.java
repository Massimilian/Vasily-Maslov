package ru.job4j.homeworks;

//11.230. Фирма имеет два магазина. Известен доход каждого магазина за каждый день
//        февраля. Определить, в каком из магазинов общий доход за месяц меньше.

class Shop {
    private String name;
    private int[] incomes;

    public Shop(String name, int[] incomes) {
        this.name = name;
        this.incomes = incomes;
    }

    public String getName() {
        return name;
    }

    public int sumOfIncomes() {
        int sum = 0;
        for (int income : incomes) {
            sum += income;
        }
        return sum;
    }
}

public class Task11230 {
    public String whenAskTheBetterShopThenReturnIt(Shop shop1, Shop shop2) {
        return shop1.sumOfIncomes() > shop2.sumOfIncomes() ? String.format("%s has bigger income (%d)", shop1.getName(), shop1.sumOfIncomes()) : shop1.sumOfIncomes() == shop2.sumOfIncomes() ? String.format("%s and %s has equal incomes", shop1.getName(), shop2.getName()) : String.format("%s has bigger income (%d)", shop2.getName(), shop2.sumOfIncomes());
    }
}
