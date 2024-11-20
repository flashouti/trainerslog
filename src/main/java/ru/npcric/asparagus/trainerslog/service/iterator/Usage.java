package ru.npcric.asparagus.trainerslog.service.iterator;

public class Usage {
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        MyIterator<String> iterator = list.iterator();

        System.out.println("Iterating forward:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Iterating backward:");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
