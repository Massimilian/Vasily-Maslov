package ru.job4j.piterservis;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class WordIndex {
    private String fileName = "";

    public void loadFile(String filename) {
        this.fileName = filename.toLowerCase();
    }

    public Set<Integer> getIndexes4Word(String searchWord) {
        searchWord = searchWord.toLowerCase();
        Set<Integer> result = new LinkedHashSet<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            list.add(searchWord.charAt(i));
        }
        for (long i = 0; i < this.fileName.length(); i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (fileName.charAt((int) i + j) == list.get(j)) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == list.size()) {
                result.add((int) i);
            }
        }
        return result;
    }
}
