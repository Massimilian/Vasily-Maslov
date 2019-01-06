package ru.job4j.storage;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StorageTest {
    private MainCheck test = new MainCheck();
    private long now = System.currentTimeMillis();
    private long minute = 60000L;
    private long nowPlusFourSeconds = now + minute / 15;
    private long nowPlusSixSeconds = now + minute / 10;
    private long nowPlusEightSeconds = now + minute / 15 * 2;
    private long nowPlusTenSeconds = now + minute / 6;
    private int waitTime = 2000;

    private Food one = new Food("One", now, nowPlusFourSeconds, 100.0);
    private Food two = new Food("Two", now, nowPlusSixSeconds, 200.0);
    private Food three = new Food("Three", now, nowPlusEightSeconds, 300.0);
    private Food four = new Food("Four", now, nowPlusTenSeconds, 400.0);

    @Test
    public void whenTryToCheckTheMainMethodThenLookThatItWorksWell() {
        test.getNewFood(one);
        test.getNewFood(two);
        test.getNewFood(three);
        test.getNewFood(four);
        test.checkFoods(test.getFood());
        assertThat(test.getWarehouse().getContainer().size(), is(4));
        assertThat(test.getShop().getContainer().size(), is(0));
        assertThat(test.getTrash().getContainer().size(), is(0));
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.checkFoods(test.getFood());
        System.out.println("Two seconds passed. 'Four' is in the warehouse, other foods are in the shop.");
        assertThat(test.getWarehouse().getContainer().size(), is(1));
        assertThat(test.getShop().getContainer().size(), is(3));
        assertThat(test.getTrash().getContainer().size(), is(0));
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.checkFoods(test.getFood());
        System.out.println("Two more seconds passed. 'Four', 'Three' and 'Two' are in the shop, 'One' is in the trash.");
        assertThat(test.getWarehouse().getContainer().size(), is(0));
        assertThat(test.getShop().getContainer().size(), is(3));
        assertThat(test.getTrash().getContainer().size(), is(1));

        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.checkFoods(test.getFood());
        System.out.println("Two more seconds passed. 'Four' and 'Three' are in the shop, 'One' and 'Two' are in the trash.");
        assertThat(test.getWarehouse().getContainer().size(), is(0));
        assertThat(test.getShop().getContainer().size(), is(2));
        assertThat(test.getTrash().getContainer().size(), is(2));

        try {
            Thread.sleep(waitTime + 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.checkFoods(test.getFood());
        System.out.println("Two more seconds passed. 'Four' is in the shop, others are in the trash. Four has a great discount, I hope.");
        assertThat(test.getWarehouse().getContainer().size(), is(0));
        assertThat(test.getShop().getContainer().size(), is(1));
        assertThat(test.getTrash().getContainer().size(), is(3));
        assertThat(test.getFood().get(3).isDiscount(), is(true));


        try {
            Thread.sleep(waitTime + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.checkFoods(test.getFood());
        System.out.println("All goods are in the trash.");
        assertThat(test.getWarehouse().getContainer().size(), is(0));
        assertThat(test.getShop().getContainer().size(), is(0));
        assertThat(test.getTrash().getContainer().size(), is(4));
    }
}