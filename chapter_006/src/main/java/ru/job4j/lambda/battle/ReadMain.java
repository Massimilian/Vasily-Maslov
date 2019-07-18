package ru.job4j.lambda.battle;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadMain {
    public static void main(String[] args) throws IOException { // ошибки не обрабатываю, так как класс является просто средством показа.
        File log = new File("C:\\projects\\Vasily-Maslov\\chapter_006\\src\\main\\java\\ru\\job4j\\lambda\\battle\\files\\battlelog.txt");
        FileReader fr = new FileReader(log);
        int forRead;
        while ((forRead = fr.read()) != -1) {
            System.out.print((char) forRead);
        }
        fr.close();
    }
}
