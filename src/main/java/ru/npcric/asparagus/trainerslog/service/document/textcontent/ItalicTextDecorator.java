package ru.npcric.asparagus.trainerslog.service.document.textcontent;

public class ItalicTextDecorator extends TextDecorator {

    public ItalicTextDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getContent() {
        return "<i>" + super.getContent() + "</i>";
    }
}

