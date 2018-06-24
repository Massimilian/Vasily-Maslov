package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11230Test {
    Task11230 test = new Task11230();
    private Shop shop1 = new Shop("Shop1", new int[]{5, 5, 5});
    private Shop shop2 = new Shop("Shop2", new int[]{5, 6, 4});
    private Shop shop3 = new Shop("GoodShop", new int[]{6, 5, 5});

    @Test
    public void whenAskTheMostGoodShopThenTellUs() {
        assertThat(test.whenAskTheBetterShopThenReturnIt(shop1, shop3), is("GoodShop has bigger income (16)"));
    }

    @Test
    public void whenAskTheMostGoodShopThenTellUsEqualVersion() {
        assertThat(test.whenAskTheBetterShopThenReturnIt(shop1, shop2), is("Shop1 and Shop2 has equal incomes"));
    }
}
