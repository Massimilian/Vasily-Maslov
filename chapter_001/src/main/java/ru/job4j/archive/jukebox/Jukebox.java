package ru.job4j.archive.jukebox;

public class Jukebox {
    public void music(int position) {
        String s = position == 1 ? "Пусть бегут неуклюже..." : position == 2 ? "Cпокойной ночи" : "Песня не найдена";
        System.out.println(s);
    }
}
