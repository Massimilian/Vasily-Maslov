package ru.job4j.emailnotification;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EMailNotificationTest {
    private User u = new User("1", "qwe@qwe.qwe");

    @Test
    public void whenTryToMakeCorrectAndIncorrectMailThenDoIt() {
        assertThat("qwedsdsddsdsd.dsdde".matches(u.getReg()), is(false));
        assertThat("someMail@mail.de".matches(u.getReg()), is(true));
    }
}
