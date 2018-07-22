package ru.job4j.threads.threadsproblems.cashnotrenovated;

public class CashNotRenovatedShow {
    public static void main(String[] args) {
//        Создаём некий класс Incrementator, который будет возвращать изменённое значение
        Incrementator incr = new Incrementator();
//        Создаём два потока, которые по-разному будут работать с этим классом. Каждый класс будет оставлять свою "метку".
        Thread one = new Thread(new CashClass(incr, 1, true));
        Thread two = new Thread(new CashClass(incr, -1, false));
//        Стартуем
        one.start();
        two.start();
        for (int i = 0; i < 50; i++) {
//            Проверяем. Результат каждый раз будет вполне рандомным.
//            Кажется, бороться с этим можно при помощи слова volatile, но как - пока не нашёл ответа.
            System.out.print("Count is " + incr.count);
            if (incr.whoRenovatesLast) {
                System.out.println(": the last thread was number one.");
            } else {
                System.out.println(": the last thread was number two.");
            }
            try {
//                Время от времени засыпаем, чтобы дать объектам неного поработать самостоятельно.
                Thread.sleep(1031);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
