package ru.job4j.arrayconvert;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConvertArrayToListTest {
    ConvertArrayToList catl = new ConvertArrayToList();
    List<Integer> list = new ArrayList<>();

    @Test
    public void whenPutArrayIntoListFormatThenDoIt() {
        for (int i = 0; i < 15; i++) {
            list.add(i + 1);
        }
        assertThat(catl.toList(new int[][]{{1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14, 15}}), is(list));
    }
}
