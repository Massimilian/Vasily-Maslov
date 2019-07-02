package ru.job4j.lambda.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LevelOf {
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().flatMap(Stream::ofNullable).sorted((c1, c2) -> c2.getScope() - c1.getScope()).takeWhile(v -> v.getScope() >= bound).collect(Collectors.toList());
    }
}
