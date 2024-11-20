package ru.npcric.asparagus.trainerslog.service.iterator;

import java.util.NoSuchElementException;

public class MyIterator<T> implements Iterator<T> {
    private DoublyLinkedList<T> list;
    private Node<T> current;

    public MyIterator(DoublyLinkedList<T> list) {
        this.list = list;
        this.current = list.getHead(); // Начинаем с головы списка
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements to iterate.");
        }
        T data = current.data;
        current = current.next; // Переходим к следующему элементу
        return data;
    }

    public boolean hasPrevious() {
        return current != null && current.prev != null;
    }

    public T previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException("No previous elements.");
        }
        current = current.prev; // Переходим к предыдущему элементу
        return current.data;
    }
}

