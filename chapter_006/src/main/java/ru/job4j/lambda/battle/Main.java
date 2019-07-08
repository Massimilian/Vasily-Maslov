package ru.job4j.lambda.battle;


public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        field.info();
        while (!field.isDown()) {
            field.battle();
        }
        field.info();
        field.end();
    }
}
