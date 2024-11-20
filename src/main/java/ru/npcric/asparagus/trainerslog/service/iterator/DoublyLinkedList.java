package ru.npcric.asparagus.trainerslog.service.iterator;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void remove(T item) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next; // Удаляем голову
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; // Удаляем хвост
                }
                size--;
                return;
            }
            current = current.next;
        }
        throw new NoSuchElementException("Element not found.");
    }

    public int size() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public MyIterator<T> iterator() {
        return new MyIterator<>(this);
    }
}

