package ru.job4j.homeworks;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Task1439Test {
    private Task1439 task;
    private String address = "src/main/java/ru/job4j/homeworks/files/TestFileTask1439.txt";
    private StringBuilder result = new StringBuilder();
    private String info = "Some information";
    private FileWriter fw = null;
    private FileReader fr = null;
    private File file;

    @Test
    public void whenTryToGetNewFileThenDoIt() {
        task = new Task1439();
        assertThat(task.getRoot().exists(), is(true));
    }

    @Test
    public void whenTryToWriteFileThenDoIt() {
        task = new Task1439();
        file = new File(address);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            fw = new FileWriter(file);
            fw.write(info);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        task.writeFile(address);
        try {
            fr = new FileReader(task.getRoot());
            int forRead;
            while ((forRead = fr.read()) != -1) {
                result.append((char) forRead);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(result.toString(), is(info));
    }
}
