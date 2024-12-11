package ru.npcric.asparagus.trainerslog.service.visitor;

public class Invoice implements Element {
    private String invoiceNumber;

    public Invoice(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
