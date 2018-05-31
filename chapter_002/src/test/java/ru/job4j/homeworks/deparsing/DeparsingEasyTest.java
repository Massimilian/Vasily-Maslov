package ru.job4j.homeworks.deparsing;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DeparsingEasyTest {
    DeparsingEasy deya = new DeparsingEasy();
    String easyWithGarbage = "(fsdf)fdf{sdfsdfs}fs[dfsf]sf";
    String medium = "({)}{}[]][}]";
    String hard = "[{[([])]}][]]";

    @Test
    public void whenAskToParseEasyStringThenReturnItParsed() {
        assertThat(deya.deparse(easyWithGarbage), is(new int[][]{{0, 5}, {9, 17}, {20, 25}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}));
    }

    @Test
    public void whenAskToParseNotSoEasyStringThenReturnItParsed() {
        assertThat(deya.deparse(medium), is(new int[][]{{4, 5}, {6, 7}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}));
    }

    @Test
    public void whenAskToParseVeryHardStringThenReturnItParsed() {
        assertThat(deya.deparse(hard), is(new int[][]{{4, 5}, {3, 6}, {2, 7}, {1, 8}, {0, 9}, {10, 11}}));
    }
}
