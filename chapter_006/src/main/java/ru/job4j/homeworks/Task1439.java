package ru.job4j.homeworks;

//14.39. Имеется файл с числами.
//       Переписать все числа в другой файл. Размер заданного файла неизвестен.

import java.io.*;

public class Task1439 {
    File root = new File("src/main/java/ru/job4j/homeworks/files/FileTask1439.txt");

    public File getRoot() {
        return root;
    }

    public Task1439() {
        if (root.exists()) {
            root.delete();
        }
        try {
            root.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String address) {
        File file = new File(address);
        StringBuilder sb = new StringBuilder();
        FileWriter fw = null;
        try {
            FileReader fr = new FileReader(file);
            int forRead;
            while ((forRead = fr.read()) != -1) {
                sb.append((char) forRead);
            }
            fr.close();
            fw = new FileWriter(root);
            fw.write(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
