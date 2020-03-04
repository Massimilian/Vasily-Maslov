package ru.job4j.crudservlet;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddServletTest {
    @Test
    public void wheTryAddThenDoIt() throws ServletException, IOException {
        WorkServlet servlet = new WorkServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        DBStore.getInstance().setCommand("add");
        when(req.getParameter("name")).thenReturn("Petr");
        when(req.getParameter("login")).thenReturn("Parsentiev");
        when(req.getParameter("mail")).thenReturn("PetrArsentiev@mail.ru");
        //
    }
}
