package ru.npcric.asparagus.trainerslog.service.document;

import java.util.ArrayList;
import java.util.List;

public class Document implements DocumentComponent {
    private List<DocumentComponent> components = new ArrayList<>();

    @Override
    public void addComponent(DocumentComponent component) {
        components.add(component);
    }

    @Override
    public void removeComponent(DocumentComponent component) {
        components.remove(component);
    }

    @Override
    public void print() {
        for (DocumentComponent component : components) {
            component.print();
        }
    }
}