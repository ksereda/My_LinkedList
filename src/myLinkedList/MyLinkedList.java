package myLinkedList;

import java.util.Iterator;

public class MyLinkedList<E> implements MyLinkedInterface<E>, Iterable<E>, DescendingIterator<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    public MyLinkedList() {
        lastNode = new Node<E>(null, firstNode, null);
        firstNode = new Node<E>(null, null, lastNode);
    }

    @Override
    public void addLastElement(E e) {
        Node<E> prev = lastNode;
        prev.setCurrentElem(e);
        lastNode = new Node<E>(null, prev, null);
        prev.setNextElem(lastNode);
        size++;
    }

    @Override
    public void addFirstElement(E e) {
        Node<E> next = firstNode;
        next.setCurrentElem(e);
        firstNode = new Node<E>(null, null, next);
        next.setPrevElem(firstNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElementByIndex(int index) {
        Node<E> result = firstNode.getNextElem();
        for (int i = 0; i < index; i++) {
            result = getNode(result);
        }
        return result.getCurrentElem();
    }

    private Node<E> getNode(Node<E> currentNode) {
        return currentNode.getNextElem();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                return getElementByIndex(count++);
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {

            int count = size - 1;

            @Override
            public boolean hasNext() {
                return count >= 0;
            }

            @Override
            public E next() {
                return getElementByIndex(count--);
            }
        };
    }

    private class Node<E> {

        private E currentElem;
        private Node<E> nextElem;
        private Node<E> prevElem;

        private Node(E currentElem, Node<E> prevElem, Node<E> nextElem) {
            this.currentElem = currentElem;
            this.nextElem = nextElem;
            this.prevElem = prevElem;
        }

        public E getCurrentElem() {
            return currentElem;
        }

        public void setCurrentElem(E currentElem) {
            this.currentElem = currentElem;
        }

        public Node<E> getNextElem() {
            return nextElem;
        }

        public void setNextElem(Node<E> nextElem) {
            this.nextElem = nextElem;
        }

        public Node<E> getPrevElem() {
            return prevElem;
        }

        public void setPrevElem(Node<E> prevElem) {
            this.prevElem = prevElem;
        }
    }

}
