package myLinkedList;

public interface MyLinkedInterface<E> {

    void addLastElement(E e);

    void addFirstElement(E e);

    int size();

    E getElementByIndex(int index);

}
