package ru.npcric.asparagus.trainerslog.service.iterator;

// Реализация паттерна Iterator
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
