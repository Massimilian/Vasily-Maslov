package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12283Test {
    Task12283 test = new Task12283();
    char[][] testing = {{' ', 'щ', 'щ', ' ', '8'}, {'ш', '7', 'щ', ' ', '='}, {' ', ' ', ' ', '`', 'щ'}};
    char[][] testingTwo = {{'8', 'щ', 'щ', ' ', ' '}, {' ', ' ', ' ', '`', 'щ'}, {'ш', '7', 'щ', '=', ' '}};
    char[] forTest = {'ш', 'щ'};

    @Test
    public void whenTryToFindTheColumnWithMaxNumberOfSpacesThenDoIt() {
        assertThat(test.maxCol(testing), is(0));
        assertThat(test.maxCol(testingTwo), is(4));
    }

    @Test
    public void whenTryToFindTheLastArrayWithMaxSymbolsThenDoIt() {
        assertThat(test.lastMaxSymb(testing, forTest, true), is(1));
        assertThat(test.lastMaxSymb(testingTwo, forTest, true), is(2));
    }

    @Test
    public void whenRtyToFindFirstMaxWithNumbersThenDoIt() {
        assertThat(test.findNums(testing), is(0));
        assertThat(test.findNums(testingTwo), is(0));
    }
}
