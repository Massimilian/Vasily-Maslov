package ru.job4j.lambda.address;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(s -> s.getAddress()).collect(Collectors.toList());
    }
}
