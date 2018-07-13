package ru.job4j.map;

import org.junit.Test;
import ru.job4j.map.users.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapWorkingPlaceTest {
    private Object anything = new Object();
    private AbstractUser user1;
    private AbstractUser user2;
    private Map<AbstractUser, Object> map = new HashMap<>();

    @Test
    public void whenAddTwoEqualsObjectsWithoutOverridingEqualsAndHashCodeThenReturnMapWithTwoObjects() {
        user1 = new User("Igor", 3, new GregorianCalendar(1990, 11, 12));
        user2 = new User("Igor", 3, new GregorianCalendar(1990, 11, 12));
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
    public void whenAddTwoEqualsObjectsWithoutOverrodeEqualsAndWithOverrodeHashCodeThenReturnMapWithTwoObjects() {
        user1 = new UserWithHash("Igor", 3, new GregorianCalendar(1990, 11, 12));
        user2 = new UserWithHash("Igor", 3, new GregorianCalendar(1990, 11, 12));
        map.put(user1, anything);
        map.put(user2, anything);

        // В данном случае мы переопределили функцию hashCode(), и теперь мы вызываем не значение hashCode()
        // конкретного объекта UserWithHash, а сумму hash-кодов составляющих данный объект (в данном случае - 1978839649).
        // Сумма одинаковая у обоих объектов (так как все составляющие - Calendar, String и int обладают переопределёнными методами
        // hashCode(), соответственно одинаковые объекты дают одинаковый hashCode()), поэтому по hashCode объекты - одинаковые.
        // Но, тем не менее, они всё ещё не идентичны по equals(так как ссылаются на разные ячейки памяти),
        // поэтому расцениваются как разные объекты и успешно добавляются в коллекцию.

        assertThat(user1.hashCode() == user2.hashCode(), is(true));
        assertThat(user1.equals(user2), is(false));
        assertThat(map.size(), is(2));
    }

    @Test
    public void whenAddTwoEqualsObjectsWithOverrodeEqualsAndWithoutOverrodeHashCodeThenReturnMapWithTwoObjects() {
        user1 = new UserWithEquals("Igor", 3, new GregorianCalendar(1990, 11, 12));
        user2 = new UserWithEquals("Igor", 3, new GregorianCalendar(1990, 11, 12));
        map.put(user1, anything);
        map.put(user2, anything);

        // Теперь у нас переопредела функция equals(). Если раньше она просто смотрела, на что (конкретнее - на какое место в памяти)
        // идёт ссылка, то теперь она сравнивает все объекты поотдельности (как и в HashCode(), метод equals()
        // переопределён в int, String и Calendar). Но, так как в нашем классе не переопределён метод hashCode(),
        // то для JVM эти два объекта разные (как мы помним, не добавляется в коллекцию объект только тот,
        // который одинаковый по hashCode() и по equals()).
        // Поэтому оба объекта успешно добавлены в коллекцию map.
        // P.S. Поправил прошлый код - закралась ошибка.

        assertThat(user1.hashCode() == user2.hashCode(), is(false));
        assertThat(user1.equals(user2), is(true));
        assertThat(map.size(), is(2));
    }

    @Test
    public void whenAddTwoEqualsObjectsWithOverrodeEqualsAndHashCodeThenReturnMapWithOnlyOneObjec() {
        user1 = new UserWithEqualsAndHash("Igor", 3, new GregorianCalendar(1990, 11, 12));
        user2 = new UserWithEqualsAndHash("Igor", 3, new GregorianCalendar(1990, 11, 12));
        map.put(user1, anything);
        map.put(user2, anything);

        // Теперь мы переопределили и HashCode(), и equals(). При проверке во время добавления (.put),
        // мы сравниваем оба объекта сначала по hash - и приходим к выводу, что hash одинаковый,
        // а затем сравниваем по equals - и снова приходим к выводу, что речь идёт об одном и том же объекте.
        // Дубликаты ключей в Map недопустимы, поэтому второе значение затирает первое. Таким образом,
        // в результате мы имеем коллекцию типа Map с одним добавленным значением.
        // P.S. Традиционно немного поправил старый код.

        assertThat(user1.hashCode() == user2.hashCode(), is(true));
        assertThat(user1.equals(user2), is(true));
        assertThat(map.size(), is(1));
    }
}
