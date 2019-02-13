package ru.job4j.chainstorage;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ChainStorageTest {
    private FoodManager fm;
    private long now = System.currentTimeMillis();
    private long tenSeconds = 6000L;
    private long nowPlusFifteenthOfTenSeconds = now + tenSeconds / 15;
    private long second = now + tenSeconds / 10;
    private long someMoreThenSecond = now + tenSeconds / 15 * 2;
    private long moreThenSecond = now + tenSeconds / 6;
    private int waitTime = 200;

    @Test
    public void whenTryToPutSomeFoodsIntoWarehouseThenDoIt() {
        Food first = new Food("First", now, nowPlusFifteenthOfTenSeconds, 100);
        Food second = new Food("Second", now, nowPlusFifteenthOfTenSeconds, 100);
        ArrayList<Food> goods = new ArrayList<>();
        goods.add(first);
        goods.add(second);
        fm = new FoodManager(goods);
        fm.getWarehouse().renovate(goods);
        assertThat(fm.getWarehouse().getGoods().size(), is(2));
    }

    @Test
    public void whenTryToUseAllStoragesInTimeThenDoIt() {
        Food one = new Food("One", now, nowPlusFifteenthOfTenSeconds, 100.0);
        Food two = new Food("Two", now, second, 200.0);
        Food three = new Food("Three", now, someMoreThenSecond, 300.0);
        Food four = new Food("Four", now, moreThenSecond, 400.0);
        ArrayList<Food> goods = new ArrayList<>();
        goods.add(one);
        goods.add(two);
        goods.add(three);
        goods.add(four);
        fm = new FoodManager(goods);
        fm.action();
        assertThat(fm.getWarehouse().getGoods().size(), is(4));
        assertThat(fm.getShop().getGoods().size(), is(0));
        assertThat(fm.getTrash().getGoods().size(), is(0));
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fm.action();
        System.out.println("1/5 of second passed. 'Four' is in the warehouse, other foods are in the shop.");
        assertThat(fm.getWarehouse().getGoods().size(), is(1));
        assertThat(fm.getShop().getGoods().size(), is(3));
        assertThat(fm.getTrash().getGoods().size(), is(0));
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fm.action();
        System.out.println("1/5 more of second passed. 'Four', 'Three' and 'Two' are in the shop, 'One' is in the trash.");
        assertThat(fm.getWarehouse().getGoods().size(), is(0));
        assertThat(fm.getShop().getGoods().size(), is(3));
        assertThat(fm.getTrash().getGoods().size(), is(1));
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fm.action();
        System.out.println("1/5 more of second passed. 'Four' and 'Three' are in the shop, 'One' and 'Two' are in the trash.");
        assertThat(fm.getWarehouse().getGoods().size(), is(0));
        assertThat(fm.getShop().getGoods().size(), is(2));
        assertThat(fm.getTrash().getGoods().size(), is(2));
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fm.action();
        System.out.println("1/5 more of second passed. 'Four' is in the shop, others are in the trash.");
        assertThat(fm.getWarehouse().getGoods().size(), is(0));
        assertThat(fm.getShop().getGoods().size(), is(1));
        assertThat(fm.getTrash().getGoods().size(), is(3));
        try {
            Thread.sleep(waitTime + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fm.action();
        System.out.println("All goods are in the trash.");
        assertThat(fm.getWarehouse().getGoods().size(), is(0));
        assertThat(fm.getShop().getGoods().size(), is(0));
        assertThat(fm.getTrash().getGoods().size(), is(4));
    }

    @Test
    public void whenTryToUseNewStoragesInTimeThenDoIt() {

    }
}
