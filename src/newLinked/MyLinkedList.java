package newLinked;

import java.util.Iterator;

public class MyLinkedList<E> implements MyLinkedInterface<E>, Iterable<E>, DescendingIterator<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    public MyLinkedList() {
        lastNode = new Node<>();
        firstNode = new Node<>();
    }

    @Override
    public void addLastElement(E e) {
        Node<E> currentElement = lastNode;
        currentElement.setValue(e);
        lastNode = new Node<>();
        lastNode.setPrevElement(currentElement);
        currentElement.setNextElement(lastNode);
        size++;
    }

    @Override
    public void addFirstElement(E e) {
        Node<E> currentElement = firstNode;
        currentElement.setValue(e);
        firstNode = new Node<>();
        firstNode.setNextElement(currentElement);
        currentElement.setPrevElement(firstNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElementByIndex(int index) {
        Node<E> result = firstNode.getNextElement();
        for (int i = 0; i < index; i++) {
            result = getNode(result);
        }
        return result.getValue();
    }

    private Node<E> getNode(Node<E> currentNode) {
        return currentNode.getNextElement();
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

        private E value;
        private Node<E> nextElement;
        private Node<E> prevElement;

        private Node() {
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }
    }

}
