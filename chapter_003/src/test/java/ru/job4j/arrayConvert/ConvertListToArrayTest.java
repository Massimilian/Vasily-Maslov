package ru.job4j.arrayconvert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConvertListToArrayTest {
    List<Integer> list = new ArrayList<>();
    ConvertListToArray clta = new ConvertListToArray();
    List<int[]> arrList = new ArrayList<>();

    @Test
    public void whenAskToFillCollectionWithNumbersThenReturnItInFormatOfArray() {
        for (int i = 0; i < 7; i++) {
            list.add(i);
        }
        assertThat(clta.toArray(list, 4), is(new int[][]{{0, 1, 2, 3}, {4, 5, 6, 0}}));
    }

    @Test
    public void whenAskToFillCollectionWithNumbersWithoutZerosThenReturnItInFormatOfArray() {
        for (int i = 1; i <= 12; i++) {
            list.add(i);
        }
        assertThat(clta.toArray(list, 3), is(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}}));
    }

    @Test
    public void whenAskToConvertTheListOfArraysThenDoIt() {
        arrList.add(new int[]{1, 2});
        arrList.add(new int[]{3, 4, 5, 6});
        list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(clta.convert(arrList), is(list));
    }
}
