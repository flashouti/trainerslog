package ru.npcric.asparagus.trainerslog.service.document;

import java.util.Stack;

public class DocumentManager {
    private final Stack<Document.Memento> mementos = new Stack<>();
    private final Document document;

    public DocumentManager(Document document) {
        this.document = document;
    }

    public void save() {
        mementos.push(document.save());
    }

    public void undo() {
        if (!mementos.isEmpty()) {
            Document.Memento memento = mementos.pop();
            document.restore(memento);
        } else {
            System.out.println("No states to undo.");
        }
    }
}