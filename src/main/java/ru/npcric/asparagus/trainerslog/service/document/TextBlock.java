package ru.npcric.asparagus.trainerslog.service.document;

public class TextBlock implements DocumentComponent {
    private String text;

    public TextBlock(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        System.out.println("Text: " + text);
    }

    @Override
    public void addComponent(DocumentComponent component) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void removeComponent(DocumentComponent component) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
