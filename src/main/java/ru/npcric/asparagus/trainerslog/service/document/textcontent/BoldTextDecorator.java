package ru.npcric.asparagus.trainerslog.service.document.textcontent;

public class BoldTextDecorator extends TextDecorator {

    public BoldTextDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getContent() {
        return "<b>" + super.getContent() + "</b>";
    }
}

