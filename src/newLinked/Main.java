package newLinked;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addFirstElement("one");
        list.addFirstElement("two");
        list.addFirstElement("three");
        list.addFirstElement("four");
        list.addFirstElement("five");
        list.addFirstElement("6");

        System.out.println("Size: " + list.size());
        System.out.println(list.getElementByIndex(2));

        for (String s : list) {
            System.out.println(s);
        }

    }
}
