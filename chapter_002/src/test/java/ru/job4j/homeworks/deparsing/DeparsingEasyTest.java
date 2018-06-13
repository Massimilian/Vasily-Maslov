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

    @Test
    public void whenAskToParseEasyStringThenReturnItParsedByAnotherWay() {
        assertThat(deya.deparseAnotherWay(easyWithGarbage), is(new int[][]{{21, 26}, {10, 18}, {1, 6}}));
    }

    @Test
    public void whenAskToParseNotSoEasyStringThenReturnItParsedByAnotherWay() {
        assertThat(deya.deparseAnotherWay(medium), is(new int[][]{{7, 8}, {5, 6}, {1, 3}}));
    }

    @Test
    public void whenAskToParseVeryHardStringThenReturnItParsedByAnotherWay() {
        assertThat(deya.deparseAnotherWay(hard), is(new int[][]{{11, 12}, {5, 6}, {4, 7}, {3, 8}, {2, 9}, {1, 10}}));
    }
}
