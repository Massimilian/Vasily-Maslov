package ru.job4j.pluszero;

/**
 * This is a class of automatic player
 */
public class AutomaticPlayer extends Player {
    public AutomaticPlayer(char view) {
        super(view);
    }

    @Override
    public Field makeStep(Field field) {
        field.getStep(getRec().answer(field.getSize()), this.getView());
        return field;
    }
}
