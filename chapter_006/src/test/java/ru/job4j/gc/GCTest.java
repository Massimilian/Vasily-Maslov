package ru.job4j.gc;

import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GCTest {
    private Softs s = new Softs();
    private String first = "Testing value";
    private String second = "Test";

    @Test
    public void whenTryToPutIntoSoftsValueThenDoIt() {
        // добавляем "мягкие ссылки" в коллекцию типа HashMap. Таким образом, текстовые файлы в кэш подгружены.
        s.putSoft(0, first);
        s.putSoft(1, second);
        // Проверяем, что текстовые файлы действительно добавились - вызываем мягкие ссылки на текстовые файлы.
        assertThat(s.getMap().get(0).get(), is(first));
        assertThat(s.getMap().get(1).get(), is(second));
    }
}
