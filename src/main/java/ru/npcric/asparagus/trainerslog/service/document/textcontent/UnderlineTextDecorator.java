package ru.npcric.asparagus.trainerslog.service.document.textcontent;

public class UnderlineTextDecorator extends TextDecorator {

    public UnderlineTextDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getContent() {
        return "<u>" + super.getContent() + "</u>";
    }
}

