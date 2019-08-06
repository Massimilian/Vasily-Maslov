package ru.job4j.archive.dummy;

public class DummyDic {
    public String engToRus(String eng) {
        return String.format("%s%s", "Неизвестное слово.", eng);
    }
}
