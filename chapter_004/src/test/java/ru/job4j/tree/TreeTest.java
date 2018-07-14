package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TreeTest {
    Tree<Integer> tree = new Tree<>(1);

    @Test
    public void when6ElFindLastThen6() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        tree.add(1, 2);
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test
    public void whenTryToUseIteratorThenSeeThatItWorksWell() {
        tree.add(1, 4);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        tree.add(6, 7);
        tree.add(5, 6);
        tree.add(4, 8);
        tree.add(6, 9);
        Iterator<Integer> it = tree.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
        assertThat(it.hasNext(), is(false));
    }


    @Test
    public void when6ElFindLastThen6DifficultWay() {
        tree.addByVeryDifficultWay(1, 2);
        tree.addByVeryDifficultWay(1, 3);
        tree.addByVeryDifficultWay(1, 4);
        tree.addByVeryDifficultWay(4, 5);
        tree.addByVeryDifficultWay(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmptyDifficultWay() {
        tree.addByVeryDifficultWay(1, 2);
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test
    public void whenTryToUseIteratorThenSeeThatItWorksWellDifficultWay() {
        tree.addByVeryDifficultWay(1, 4);
        tree.addByVeryDifficultWay(1, 4);
        tree.addByVeryDifficultWay(4, 5);
        tree.addByVeryDifficultWay(5, 6);
        tree.addByVeryDifficultWay(6, 7);
        tree.addByVeryDifficultWay(5, 6);
        tree.addByVeryDifficultWay(4, 8);
        tree.addByVeryDifficultWay(6, 9);
        Iterator<Integer> it = tree.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenCheckIfBinaryTreeThenReturnTrue() {
        tree.addByVeryDifficultWay(1, 4);
        tree.addByVeryDifficultWay(4, 5);
        tree.addByVeryDifficultWay(1, 6);
        tree.addByVeryDifficultWay(4, 7);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenCheckIfNotBinaryTreeThenReturnFalseEasyWay() {
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(1, 6);
        tree.add(4, 7);
        tree.add(4, 8);
        assertThat(tree.isBinary(), is(false));
    }


    @Test
    public void whenCheckIfNotBinaryTreeThenReturnFalse() {
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(1, 6);
        tree.add(4, 7);
        tree.add(4, 8);
        tree.add(8, 9);
        assertThat(tree.isBinary(), is(false));
    }

    @Test
    public void whenCheckIfNotBinaryTreeThenReturnFalseAnotherWay() {
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(1, 6);
        tree.add(4, 7);
        tree.add(5, 8);
        tree.add(5, 9);
        assertThat(tree.isBinary(), is(true));
    }


}
