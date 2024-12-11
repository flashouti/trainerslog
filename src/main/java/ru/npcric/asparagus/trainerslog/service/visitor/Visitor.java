package ru.npcric.asparagus.trainerslog.service.visitor;

public interface Visitor {
    void visit(Report report);
    void visit(Invoice invoice);
}
