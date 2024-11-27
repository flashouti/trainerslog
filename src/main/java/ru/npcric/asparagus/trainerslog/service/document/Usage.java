package ru.npcric.asparagus.trainerslog.service.document;

public class Usage {
    public static void main(String[] args) {
        Document document = new Document("Version 1");
        DocumentManager manager = new DocumentManager(document);

        System.out.println("Current Content: " + document.getContent());

        manager.save();

        // Изменяем документ
        document.setContent("Version 2");
        System.out.println("Current Content: " + document.getContent());

        manager.save();

        document.setContent("Version 3");
        System.out.println("Current Content: " + document.getContent());

        manager.undo();
        System.out.println("After Undo: " + document.getContent());

        manager.undo();
        System.out.println("After Undo: " + document.getContent());

        manager.undo();
    }
}
