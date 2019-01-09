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

    private Food one = new Food("One", now, nowPlusFourSeconds, 100.0, false, false);
    private Food two = new Food("Two", now, nowPlusSixSeconds, 200.0, true, false);
    private Food three = new Food("Three", now, nowPlusEightSeconds, 300.0, false, false);
    private Food four = new Food("Four", now, nowPlusTenSeconds, 400.0, false, true);
    private Food five = new Food("Five", now, nowPlusFourSeconds, 500.0, false, false);
    private Food six = new Food("Six", now, nowPlusSixSeconds, 600.0, true, false);
    private Food seven = new Food("Seven", now, nowPlusEightSeconds, 700.0, false, false);
    private Food eight = new Food("Eight", now, nowPlusTenSeconds, 800.0, false, true);
    private Food nine = new Food("Nine", now, nowPlusFourSeconds, 900.0, false, false);
    private Food ten = new Food("Ten", now, nowPlusSixSeconds, 1000.0, true, false);
    private Food eleven = new Food("Eleven", now, nowPlusEightSeconds, 1100.0, false, false);
    private Food twelve = new Food("Twelve", now, nowPlusTenSeconds, 1200.0, false, true);

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
        System.out.println("Two more seconds passed. 'Four' and 'Three' are in the shop, 'One' and 'Two' are in the trash ('Two' is in the special trash for reproduct).");
        assertThat(test.getWarehouse().getContainer().size(), is(0));
        assertThat(test.getShop().getContainer().size(), is(2));
        assertThat(test.getTrash().getContainer().size(), is(1));

        try {
            Thread.sleep(waitTime + 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.checkFoods(test.getFood());
        System.out.println("Two more seconds passed. 'Four' is in the shop, others are in the trash ('Two' is in the special container). Four has a great discount, I hope.");
        assertThat(test.getWarehouse().getContainer().size(), is(0));
        assertThat(test.getShop().getContainer().size(), is(1));
        assertThat(test.getTrash().getContainer().size(), is(2));
        assertThat(test.getFood().get(3).isDiscount(), is(true));


        try {
            Thread.sleep(waitTime + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.checkFoods(test.getFood());
        System.out.println("All goods are in the trash (and 'Two' is in the container for reproduct).");
        assertThat(test.getWarehouse().getContainer().size(), is(0));
        assertThat(test.getShop().getContainer().size(), is(0));
        assertThat(test.getTrash().getContainer().size(), is(2));
        assertThat(test.getFood().get(1).isCanReproduct(), is(true));
        assertThat(test.getFood().get(3).isVegetable(), is(true));
    }

    @Test
    public void whenTryToCheckManyGoodsIntoWareshopThenDividethemIntoDifferentContainers() {
        test.getNewFood(one);
        test.getNewFood(two);
        test.getNewFood(three);
        test.getNewFood(four);
        test.getNewFood(five);
        test.getNewFood(six);
        test.getNewFood(seven);
        test.getNewFood(eight);
        test.getNewFood(nine);
        test.getNewFood(ten);
        test.getNewFood(eleven);
        test.getNewFood(twelve);
        test.checkFoods(test.getFood());
        assertThat(test.getFood().size(), is(12));
        assertThat(test.getWarehouse().getContainer().size(), is(5));
    }
}