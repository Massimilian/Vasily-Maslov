package ru.job4j.pluszero;

/**
 * The class of human player
 */
public class Player {
    private char view;
    private Receiver rec;

    public Player(char view) {
        this.view = view;
        rec = new Receiver();
    }

    public char getView() {
        return view;
    }

    public Receiver getRec() {
        return rec;
    }

    public Field makeStep(Field field) {
        field.getStep(rec.answer(), this.view);
        return field;
    }
}
