package ru.job4j.differentarrays;

import java.util.Iterator;
import java.util.NoSuchElementException;

//1, 2, 3
//4, 5, 6
//7, 8, 9

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private final Iterator<Iterator<Integer>> iterator = it;
            private Iterator<Integer> current;

            @Override
            public boolean hasNext() {
                // проверяем внутренний итератор на ноль, а внешний на наличие внутренних итераторов
                if (current == null && iterator.hasNext()) {
                    current = iterator.next();
                }
                // если больше внутренних итераторов нет - возвращаем false
                if (current == null) {
                    return false;
                }
                // если  внутренний итератор имеет значения - возвращаем true
                if (current.hasNext()) {
                    return true;
                }
                // Если внешний итератор имеет итераторы - возвращаем значение этого итератора
                if (iterator.hasNext()) {
                    current = iterator.next();
                }
                // если ничего не прокатило - значит, просто возвращаем сдвигаем каретку
                return current.hasNext();
            }

            @Override
            public Integer next() {
                // если внутренний итератор отсутствует, но в будущем он предвидится - сдвигаем просмотр на следующий итератор
                if (current == null || !current.hasNext() && iterator.hasNext()) {
                    current = iterator.next();
                }
                // а если нет - просто даём следующее значение
                return current.next();
            }
        };
    }
}
