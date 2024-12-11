package ru.npcric.asparagus.trainerslog.service.visitor;

public class Report implements Element {
    private String title;

    public Report(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
