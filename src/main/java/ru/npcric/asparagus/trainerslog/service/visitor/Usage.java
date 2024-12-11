package ru.npcric.asparagus.trainerslog.service.visitor;

import java.util.ArrayList;
import java.util.List;

public class Usage {
    public static void main(String[] args) {
        List<Element> elements = new ArrayList<>();
        elements.add(new Report("Annual Report"));
        elements.add(new Invoice("INV-12345"));

        Visitor printVisitor = new PrintVisitor();

        for (Element element : elements) {
            element.accept(printVisitor);
        }
    }
}
