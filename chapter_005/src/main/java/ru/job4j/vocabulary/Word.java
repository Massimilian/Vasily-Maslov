package ru.job4j.vocabulary;

public class Word {
    private String word;
    private String value;

    public Word(String word, String value) {
        this.word = word;
        this.value = value;
    }

    public String getWord() {
        return word;
    }

    public String getValue() {
        return value;
    }
}
