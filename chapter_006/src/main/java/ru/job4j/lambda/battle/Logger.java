package ru.job4j.lambda.battle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import static java.lang.String.format;

public class Logger {
    private File log = new File("battlelog.txt");
    private FileWriter fw;

    public Logger() {
        try {
            this.log.createNewFile();
            this.fw = new FileWriter(log, true);
            this.fw.write(format("%s%s%s", "BATTLE DATE: ", new Date().toString(), System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Logging method
     *
     * @param log
     */
    public void logging(String log) {
        System.out.print(log);
        try {
            fw.write(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
