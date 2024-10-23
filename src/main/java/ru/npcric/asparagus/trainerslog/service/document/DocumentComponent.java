package ru.npcric.asparagus.trainerslog.service.document;

// Реализация паттерна Composite
public interface DocumentComponent {
    void print();
    void addComponent(DocumentComponent component);
    void removeComponent(DocumentComponent component);
}
