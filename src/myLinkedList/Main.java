package myLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addLastElement("one");
        list.addLastElement("two");
        list.addLastElement("three");
        list.addLastElement("four");
        list.addLastElement("five");

        System.out.println("Size: " + list.size());
        System.out.println(list.getElementByIndex(0));

        for (String s : list) {
            System.out.println(s);
        }

    }
}
