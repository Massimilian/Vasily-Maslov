package ru.job4j.map;

import org.junit.Test;
import ru.job4j.map.Users.AbstractUser;
import ru.job4j.map.Users.User;
import ru.job4j.map.Users.UserWithHash;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapWorkingPlaceTest {
    Object anything = new Object();
    private User user1 = new User("Igor", 3, new GregorianCalendar(1990, 11, 12));
    private User user2 = new User("Igor", 3, new GregorianCalendar(1990, 11, 12));
    private UserWithHash userWithHash1 = new UserWithHash("Igor", 3, new GregorianCalendar(1990, 11, 12));
    private UserWithHash userWithHash2 = new UserWithHash("Igor", 3, new GregorianCalendar(1990, 11, 12));
    private Map<AbstractUser, Object> map = new HashMap<>();

    @Test
    public void whenAddTwoEqualsObjectsWithoutOverridingEqualsAndHashCodeThenReturnMapWithTwoObjects() {
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
        // Единственный вопрос, на который пока не удалось найти ответа - по какой формуле определяется hashCode объекта?

        assertThat(user1.hashCode() == user2.hashCode(), is(false));
        assertThat(user1.equals(user2), is(false));
        assertThat(map.size(), is(2));
    }

    @Test
    public void whenAddTwoEqualsObjectsWithoutOverridingEqualsAndWithOverridedHashCodeThenReturnMapWithTwoObjects() {
        map.put(userWithHash1, anything);
        map.put(userWithHash2, anything);
        System.out.println(userWithHash1.hashCode());
        // В данном случае мы переопределили функцию hashCode(), и теперь мы вызываем не значение hashCode()
        // конкретного объекта UserWithHash, а сумму hash-кодов составляющих данный объект (в данном случае - 1978839649).
        // Сумма одинаковая у обоих объектов (так как все составляющие - Calendar, String и int обладают переопределёнными методами
        // hashCode(), соответственно одинаковые объекты дают одинаковый hashCode()), поэтому по hashCode объекты - одинаковые.
        // Но, тем не менее, они всё ещё не идентичны по equals(так как ссылаются на разные ячейки памяти),
        // поэтому расцениваются как разные объекты и успешно добавляются в коллекцию.

        assertThat(userWithHash1.hashCode() == userWithHash2.hashCode(), is(true));
        assertThat(user1.equals(user2), is(false));
        assertThat(map.size(), is(2));
    }
}
