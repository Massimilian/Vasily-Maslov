package ru.job4j.homeworks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11223Test {
    private Task11223 test = new Task11223();
    private int[] goals = {1, 2, 3};
    private int[] goodGoals = {6, 2, 3};
    private int[] falses = {3, 2, 1};
    private List<Integer> goal = new ArrayList<>(Arrays.asList(1, 2, 3));
    private List<Integer> fall = new ArrayList<>(Arrays.asList(3, 2, 1));

    @Test
    public void whenAskResultsTheReturnInStringFormat() {
        assertThat(test.games(goals, falses), is("Game №1. Count 1:3. Result - false.\nGame №2. Count 2:2. Result - drawn game.\nGame №3. Count 3:1. Result - victory.\n"));
    }

    @Test
    public void whenAskResultsTheReturnInStringFormatListVariation() {
        assertThat(test.games(goal, fall), is("Game №1. Count 1:3. Result - false.\nGame №2. Count 2:2. Result - drawn game.\nGame №3. Count 3:1. Result - victory.\n"));
    }

    @Test
    public void whenAskAllResultsInArrayFormThenReturnThem() {
        assertThat(test.gamesResult(goals, falses), is(new int[]{1, 1, 1}));
    }

    @Test
    public void whenAskMostInteretingGamesThenReturnThem() {
        assertThat(test.interestingGame(goodGoals, falses), is("Most interesting games: \n number 1"));
    }

    @Test
    public void whenAskChampionCountThenReturnIt() {
        assertThat(test.count(goals, falses), is(4));
    }

}
