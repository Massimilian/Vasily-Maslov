package ru.job4j.map;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapWorkingPlaceTest {
    private User user1 = new User("Igor", 3, new GregorianCalendar(1990, 11, 12));
    private User user2 = new User("Igor", 3, new GregorianCalendar(1990, 11, 12));
    private Map<User, Object> map = new HashMap<User, Object>();

    @Test
    public void whenAddTwoEqualsObjectsWithoutOverridingEqualsAndHashCodeThenReturnMapWithTwoObjects() {
        Object anything = new Object();
        map.put(user1, anything);
        map.put(user2, anything);
        // В созданную карту мы вводим два объекта (в качестве ключей) в которых не переопределены методы equals() и hashCode().
        // Соответственно, данные методы будут отрабатывать по умолчанию.
        // hashCode() будет генерировать каждый раз новое число,
        // заполняя тем самым хэш-таблицу, а каждое следующее число будет зависеть от состояния заполненности хэш-таблицы
        // на данный момент. На данный момент хэш-код объекта user1 равен 358699161, user2 - 517938326
        // (точную формулу рассчёта по умолчанию найти не удалось). Если мы удалим объект user1, то hashCode объекта user2
        // станет равен состоянию hashCode объекта user1 на данный момент. Если мы поменяем местами создание user1 и user2 -
        // они поменяются значениями hashCode.
        // Equals будет возвращать false, так как объекты по сути равны, но - что важно для equals - фактически неидентичны.
        // Даже если мы создадим очень много объектов, количество которых будет таково, что hashCode некоторых начнёт совпадать
        // (коллизия), то от этого они не станут equals, так как будут ссылаться на разные ячейки памяти.
        // Если же мы продолжим создание объектов и создадим количество объектов большее, чем количество ячеек памяти,
        // то получим OutOfMemoryError.

        assertThat(user1.hashCode() == user2.hashCode(), is(false));
        assertThat(user1.equals(user2), is(false));
        assertThat(map.size(), is(2));
    }
}
