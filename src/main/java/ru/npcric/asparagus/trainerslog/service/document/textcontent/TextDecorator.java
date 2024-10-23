package ru.npcric.asparagus.trainerslog.service.document.textcontent;

// Реализация паттерна Decorator
public abstract class TextDecorator implements Text {
    protected Text decoratedText;

    public TextDecorator(Text decoratedText) {
        this.decoratedText = decoratedText;
    }

    @Override
    public String getContent() {
        return decoratedText.getContent();
    }
}
