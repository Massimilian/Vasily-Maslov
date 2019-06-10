package ru.job4j.gc;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class Softs {
    private HashMap<String, SoftReference<String>> map = new HashMap<String, SoftReference<String>>();
    private String fs = File.separator;
    private String formatter = ".txt";
    private String address = String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s", "c:", fs, "projects", fs, "Vasily-Maslov",
            fs, "chapter_006", fs, "src", fs, "test", fs, "java", fs, "ru", fs, "job4j", fs, "gc", fs);

    public SoftReference<String> getSoft(String string) {
        SoftReference<String> sr;
        if (this.map.containsKey(string)) {
            sr = map.get(string);
        } else {
            File file = new File(String.format("%s%s%s", this.address, string, this.formatter));
            if (!file.exists()) {
                System.out.println("This file not exists!");
                sr = null;
            } else {
                StringBuilder result = new StringBuilder("");
                String str;
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    while ((str = br.readLine()) != null) {
                        result.append(str);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.map.put(string, new SoftReference<String>(result.toString()));
                System.out.println("New information added!");
//                sr = map.get(string);
                sr = new SoftReference<String>(result.toString());
            }
        }
        return sr;
    }

    public HashMap<String, SoftReference<String>> getMap() {
        return map;
    }
}