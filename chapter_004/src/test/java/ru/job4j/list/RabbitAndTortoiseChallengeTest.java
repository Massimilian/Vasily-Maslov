package ru.job4j.list;

import ru.job4j.list.RabbitAndTortoiseChallenge.Node;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RabbitAndTortoiseChallengeTest {
    private RabbitAndTortoiseChallenge ratc = new RabbitAndTortoiseChallenge();
    private Node first = new Node(1);
    private Node two = new Node(2);
    private Node third = new Node(3);
    private Node four = new Node(4);

    @Test
    public void whenAddCicledLinkedNodeThenReturnThatItCicled() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(ratc.hasCycle(first), is(true));
    }

    @Test
    public void whenAddNotCicledLinkedNodeThenReturnThatItCicled() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(ratc.hasCycle(first), is(false));
    }

}
