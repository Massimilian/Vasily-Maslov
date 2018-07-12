package ru.job4j.map;

import java.util.Iterator;
import java.util.Objects;

public class TestMap<K, V> implements Iterable {
    private int nodeSize = 4;
    private Node[] table = new Node[nodeSize];
    private int capacity = 0;

    public TestMap() {
        System.out.println("Attention! This map working without hash system!");
    }

    public boolean insert(K key, V value) {
        boolean hasInserted;
        Node node = new Node(key, value);
        int place = Math.abs(node.hash % nodeSize);
        if (table[place] == null) {
            table[place] = node;
            lookCapacity();
            hasInserted = true;
        } else {
            System.out.println("Cannot put this object!");
            hasInserted = false;
        }
        return hasInserted;
    }

    public V get(K key) {
        Node node = new Node(key, null);
        node = table[Math.abs(node.getHash() % nodeSize)];
        return (V) node.getValue();
    }

    public boolean delete(K key) {
        boolean hasDeleted = false;
        Node node = new Node(key, null);
        if (table[node.getHash() % nodeSize] != null) {
            table[node.getHash() % nodeSize] = null;
            capacity--;
            hasDeleted = true;
        } else {
            System.out.println("This field is empty!");
        }
        return hasDeleted;
    }

    public int getSize() {
        return capacity;
    }

    private void lookCapacity() {
        if (++capacity >= this.nodeSize * 0.75) {
            Node[] newTable = new Node[nodeSize <<= 1];
            for (Node node : table) {
                if (node != null) {
                    newTable[Math.abs(node.getHash() % newTable.length)] = node;
                }
            }
            table = newTable;
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int count = 0;

            @Override
            public boolean hasNext() {
                int tempCount = count;
                while (table[tempCount] == null && tempCount != capacity) {
                    tempCount++;
                }
                return !(tempCount == capacity);
            }

            @Override
            public Object next() {
                while (table[count] == null) {
                    count++;
                }
                return table[count++].getValue();
            }
        };
    }

    class Node<K, V> {
        private final int hash;
        private K key;
        private V value;

        public int getHash() {
            return hash;
        }

        public V getValue() {
            return value;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            hash = this.hashCode();
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}