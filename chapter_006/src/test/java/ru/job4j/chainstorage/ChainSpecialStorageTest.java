package ru.job4j.chainstorage;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class ChainSpecialStorageTest {
    private FoodManager fm;
    private long now = System.currentTimeMillis();
    private long second = 6000L;
    private long nowPlusFourSeconds = now + second / 15;
    private int waitTime = 600;

    @Test
    public void whenTryToUseDecoratorsThenWorksWitoutFalses() {
        Food first = new Food("First", now, nowPlusFourSeconds, 100);
        Food second = new Food("Second", now, nowPlusFourSeconds, 100);
        ArrayList<Food> goods = new ArrayList<>();
        goods.add(first);
        goods.add(second);
        first.setCanReproduct(true);
        second.setCanReproduct(false);
        second.setVegetable(true);
        fm = new FoodManager(goods);
        fm.action();
        assertThat(fm.getSfv().getGoods().size(), is(1));
        assertThat(fm.getSfv().getGoods().get(0).getName(), is("Second"));
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fm.action();
        assertThat(fm.getSfr().getGoods().size(), is(1));
        assertThat(fm.getSfr().getGoods().get(0).getName(), is("First"));
        assertThat(fm.getSfv().getGoods().size(), is(0));
    }

    @Test
    public void whenTryToUseControlQualityClassThenDoItSuccessfully() {
        Food first = new Food("First", now, nowPlusFourSeconds, 100);
        Food second = new Food("Second", now, nowPlusFourSeconds, 100);
        ArrayList<Food> goods = new ArrayList<>();
        goods.add(first);
        goods.add(second);
        ControlQuality cq = new ControlQuality(goods);
        cq.resort();
        assertThat(cq.getGoods().size(), is(2));
    }
}
