package ru.job4j.lambda.casting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CastMatrix {
    public List<Integer> castListArray(Integer[][] array) {
        return Arrays.stream(array).flatMap(Arrays::stream).collect(Collectors.toList());
    }


}
