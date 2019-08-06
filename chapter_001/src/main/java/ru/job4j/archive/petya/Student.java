package ru.job4j.archive.petya;

public class Student {
    public void music() {
        System.out.println("tra tra tra");
    }

    public void song() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        for (int i = 0; i < 3; i++) {
            petya.song();
        }
    }
}
