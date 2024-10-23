package ru.npcric.asparagus.trainerslog.service.document.textcontent;

public class PlainText implements Text {
    private String content;

    public PlainText(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
