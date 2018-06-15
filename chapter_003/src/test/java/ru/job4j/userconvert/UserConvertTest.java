package ru.job4j.userconvert;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UserConvertTest {
    List<User> list = new ArrayList<>();
    User user1 = new User("Julio", "Madrid");
    User user2 = new User("Ivan", "Tver");
    User user3 = new User("Pfhsdfur", "Kutlvanong");


    @Test
    public void whenAskToMakeUserHashMapThenDoIt() {
        list.addAll(Arrays.asList(user1, user2, user3));
        UserConvert uc = new UserConvert();
        HashMap<Integer, User> result = new HashMap<>();
        result.put(user1.getId(), user1);
        result.put(user2.getId(), user2);
        result.put(user3.getId(), user3);
        assertThat(uc.process(list), is(result));
    }
}
