package ru.npcric.asparagus.trainerslog.service;

import ru.npcric.asparagus.trainerslog.service.document.Document;
import ru.npcric.asparagus.trainerslog.service.document.TextBlock;

public class DocumentService {
    public void createComponent(){
        Document mainDocument = new Document();

        TextBlock text1 = new TextBlock("Hello World!");
        TextBlock text2 = new TextBlock("This is a composite pattern example.");

        Document subDocument = new Document();
        TextBlock subText1 = new TextBlock("Sub document text.");
        subDocument.addComponent(subText1);

        mainDocument.addComponent(text1);
        mainDocument.addComponent(text2);
        mainDocument.addComponent(subDocument);

        mainDocument.print();
    }

}
