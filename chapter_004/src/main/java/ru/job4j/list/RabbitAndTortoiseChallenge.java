package ru.job4j.list;

public class RabbitAndTortoiseChallenge {
    public boolean hasCycle(Node first) {
        boolean workedCycle = true;
        Node one = tortoise(first);
        Node two = rabbit(first);
        while (!one.equals(two) && workedCycle) {
            try {
                one = tortoise(one);
                two = rabbit(two);
            } catch (NullPointerException npe) {
                workedCycle = false;
            }
        }
        return workedCycle;
    }

    private Node tortoise(Node first) {
        return first.next;
    }

    private Node rabbit(Node first) {
        return first.next.next;
    }

    public static class Node<E> {
        E info;
        Node<E> next;

        Node(E info) {
            this.info = info;
        }
    }

}
