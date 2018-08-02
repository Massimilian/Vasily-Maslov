package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int size = 0;

    public Tree(E elem) {
        this.root = new Node<>(elem);
    }

    public boolean isBinaryWithoutRecursions() {
        boolean bin = true;
        ArrayList<Node> data = new ArrayList<>();
        data.add(root);
        int count = 0;
        while (bin && count < data.size()) {
            Node node = data.get(count++);
            bin = node.leaves().size() == 2 || node.leaves().size() == 0;
            data.addAll(node.leaves());
        }
        return bin;
    }

    public boolean isBinary() {
        boolean bin = false;
        if (this.size % 2 == 0) {
            if (root.leaves().size() == 2) {
                for (int i = 0; i < 2; i++) {
                    bin = lookOthers(root);
                }
            }
        }
        return bin;
    }

    private boolean lookOthers(Node node) {
        boolean bin = true;
        if (node.leaves().size() == 2) {
            for (int i = 0; i < 2; i++) {
                bin = lookOthers((Node) node.leaves().get(i));
                if (!bin) {
                    break;
                }
            }
        } else if (node.leaves().size() != 0) {
            bin = false;
        }
        return bin;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (!findBy(child).isPresent()) {
            this.findBy(parent).get().add(new Node<>(child));
            size++;
            result = true;
        } else {
            System.out.println("Cannot add this value!");
        }
        return result;
    }

    public boolean addByVeryDifficultWay(E parent, E child) {
        boolean added = false;
        Node childNode = new Node(child);
        if (root.eqValue(parent)) {
            if (check(root, childNode)) {
                root.add(childNode);
                added = true;
                size++;
            }
        } else {
            for (int i = 0; i < root.leaves().size(); i++) {
                added = addAll(root.leaves().get(i), childNode, parent);
                if (added) {
                    size++;
                    break;
                }
            }
        }
        if (!added) {
            System.out.println("Cannot be added!");
        }
        return added;
    }

    private boolean addAll(Node parentNode, Node childNode, E parent) {
        boolean added = false;
        if (parentNode.eqValue(parent)) {
            if (check(parentNode, childNode)) {
                parentNode.add(childNode);
                added = true;
            }
        } else {
            for (int i = 0; i < parentNode.leaves().size(); i++) {
                added = addAll((Node) parentNode.leaves().get(i), childNode, parent);
                if (added) {
                    break;
                }
            }
        }
        return added;
    }

    private boolean check(Node parent, Node mayBeChild) {
        boolean result = true;
        ArrayList<Node<E>> al = (ArrayList<Node<E>>) parent.leaves();
        for (Node node : al) {
            if (node.getValue().equals(mayBeChild.getValue())) {
                result = false;
            }
            break;
        }
        return result;
    }

    public Optional<Node> findBy(E value) {
        Optional<Node> rsl = Optional.empty();
        // создаём пустой Optional, который содержит в себе Node
        Queue<Node> data = new LinkedList<>();
        // создаём связный список Node-ов(которым будем пользоваться, как очередью)
        data.offer(this.root);
        // добавляем Node root, содержащийся в этом классе Tree, в связный список data.
        while (!data.isEmpty()) {
            // до того момента, пока связный список data не окажется пустым...
            Node<E> el = data.poll();
            // создаём буферный Node el, в который незамедлительно помещаем вытащенный первым номером root
            // возникает вопрос - а зачем надо было так заморачиваться со связным списком? не проще ли сразу присвоить root в el -
            // ведь список data у нас будет гарантированно содержать только один элемент Node, который и будет root?
            if (el.eqValue(value)) {
                // если введённое значение класса E value будет идентично значению value у введённого буферного Node el
                rsl = Optional.of(el);
                // результат - а именно, буферный Node el - присваиваем в rls...
                break;
                // и выходим из while
            }
            for (Node child : el.leaves()) {
                // делаем foreach для буферного Node el, в котором перечисляем все его "листья" - то есть детей, которые являются
                // частью Node, а именно ArrayList children
                data.offer(child);
                // добавляем в связный список Node-ов детей, которые также нуждаются в проверке как возможные "носители"
                // информации E value. Стало понятным, зачем понадобился цикл while.
            }
        }
        return rsl;
        // возвращаем результат
    }

    public Iterator<E> iterator() {
        return new NewIterator<>();
    }

    private class NewIterator<E> implements Iterator<E> {
        private Queue<Node> queue;
        private int expectedModCount = size;

        public NewIterator() {
            this.queue = new LinkedList<>();
            queue.add(root);
        }

        public void getChild(Node node) {
            for (Object n : node.leaves()) {
                queue.offer((Node) n);
            }
        }

        @Override
        public boolean hasNext() {
            if (expectedModCount != size) {
                throw new ConcurrentModificationException();
            }
            return !queue.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node res = queue.poll();
            getChild(res);
            return (E) res.getValue();
        }
    }
//    @Override
//    public Iterator<E> iterator() {
//        return new Iterator<E>() {
//            LinkedList<Node> data = makeData();
//            int checkSteps = size;
//
//            public LinkedList<Node> makeData() {
//                LinkedList<Node> data = new LinkedList<>();
//                adding(data, root);
//                return data;
//            }
//
//            private LinkedList<Node> adding(LinkedList<Node> data, Node node) {
//                data.add(node);
//                for (int i = 0; i < node.leaves().size(); i++) {
//                    if (node.leaves().size() > 0) {
//                        adding(data, (Node) node.leaves().get(i));
//                    }
//                }
//                return data;
//            }
//
//            @Override
//            public boolean hasNext() {
//                if (checkSteps != size) {
//                    throw new ConcurrentModificationException("The changes in time of iterator's work are impossible!");
//                }
//                return data.size() != 0;
//            }
//
//            @Override
//            public E next() {
//                if (!hasNext()) {
//                    throw new NoSuchElementException("Has no much elements!");
//                }
//                return (E) data.poll().getValue();
//            }
//        };
//    }
}
