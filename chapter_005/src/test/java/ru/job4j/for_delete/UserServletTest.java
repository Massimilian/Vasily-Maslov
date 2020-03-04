package ru.job4j.for_delete;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServletTest {
    @Test
    public void addUser() throws ServletException, IOException {
        // создадим новый экземпляр класса-сервлета, который мы планируем протестировать.
        // Тестировать мы будем метод doPost(), где и происходит основное действие
        UserServlet servlet = new UserServlet();
        // Создадим "заглушку" типа request, которая позволит нам получить доступ к редактируемому экземпляру HttpServletRequest
        HttpServletRequest req = mock(HttpServletRequest.class);
        // Аналогичном с HttpServletResponse
        HttpServletResponse resp = mock(HttpServletResponse.class);
        // В параметр login устанавливаем значение Petr
        when(req.getParameter("login")).thenReturn("Petr");
        // Вытащим коллекцию, заявленную в UserStorage
        List<User> users = UserStorage.getInstance().getUsers();
        // Запускаем метод
        servlet.doPost(req, resp);
        // Проверяем, что первый User - это User, который тут по умолчанию
        assertThat(users.get(0).getLogin(), is("root"));
        // Проверяем, что второй User - это User, который мы только что вставили
        assertThat(users.get(1).getLogin(), is("Petr"));
    }
}
