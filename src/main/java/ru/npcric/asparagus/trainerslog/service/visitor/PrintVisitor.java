package ru.npcric.asparagus.trainerslog.service.visitor;

public class PrintVisitor implements Visitor {
    @Override
    public void visit(Report report) {
        System.out.println("Printing Report: " + report.getTitle());
    }

    @Override
    public void visit(Invoice invoice) {
        System.out.println("Printing Invoice: " + invoice.getInvoiceNumber());
    }
}
