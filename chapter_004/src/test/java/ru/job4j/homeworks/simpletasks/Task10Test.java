package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task10Test {
    Task10 test = new Task10();
    String str = "(q(w(e)r)t)y(u(i)o(ooo(p)p[)[[(])j)";
    String uncorrectStr = "asd(asd)dsd(asd)asda)dasd(dasd)sadasdads(dadsdaas)sd";

    @Test
    public void whenTryToCheckTheStringWithBracesThenReturnInfo() {
        assertThat(test.allClosed(str), is(true));
        assertThat(test.allClosed(uncorrectStr), is(false));
    }
}
