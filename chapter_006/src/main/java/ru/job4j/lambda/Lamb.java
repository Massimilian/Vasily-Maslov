package ru.job4j.lambda;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Lamb {
    public static void main(String[] args) {
//        List<Person> persons = new ArrayList<>();
//        persons.add(new Person("Vasia", 36));
//        persons.add(new Person("Olga", 36));
//        persons.add(new Person("Vlad", 9));
//        persons.add(new Person("Arina", 6));
        List<Person> persons = List.of(new Person("Vasia", 35), new Person("Olga", 35), new Person("Vlad", 9), new Person("Arina", 6));

        //Stream.iterate(0, i -> i < 10, i -> ++i).forEach(System.out::println);
        //List.of(1, 2, 3, 4, 5, 6).stream().dropWhile(p -> p <= 4).forEach(System.out::println);
        //List.of(2, 3, 4, 5).stream().takeWhile(v -> v % 2 == 0).forEach(System.out::println);
        //Map<String, Integer> map = persons.stream().collect(Collectors.toMap(s -> s.getName(), b -> b.getAge()));
        //persons.stream().map(x -> x.getName().toUpperCase()).forEach(x -> System.out.println(x));
        //Stream.of(asList("a"), persons).flatMap(x -> x.stream()).forEach(System.out::println);
        //Stream<Person> stream = persons.stream();
        //persons.stream().forEach(System.out::println);
        //List<Person> list = persons.stream().filter(p -> p.getAge() < 18).collect(Collectors.toList());
        //persons.forEach(person -> System.out.println(person));
        //persons.forEach(System.out::println);
        //persons.stream().filter(p -> p.getAge() >= 18).forEach(p -> System.out.println(p.getName()));
        //persons.stream().map(p -> p.getName()).forEach(System.out::println);
        //persons.stream().sorted((c1, c2) -> c1.getName().compareTo(c2.getName())).forEach(p -> System.out.println(p.getName() + " " + p.getAge()));
        //System.out.println(Stream.of(0, 9, 1, 2, 3, 4, 5).max(Comparator.comparing(x -> x)).get());
        //int r = Stream.of(1, 2, 3, 4).reduce(1, (one, two) -> one * two);
        //System.out.println(Stream.of("a", "b", "c").limit(200).collect(Collectors.toList()));

    }
}