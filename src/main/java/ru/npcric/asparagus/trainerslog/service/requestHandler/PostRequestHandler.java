package ru.npcric.asparagus.trainerslog.service.requestHandler;

class PostRequestHandler extends ApiRequestHandler {

    @Override
    protected void processRequest() {
        System.out.println("Обработка POST-запроса...");
        // Логика обработки POST-запроса
    }

    @Override
    protected void sendResponse() {
        System.out.println("POST-запрос обработан");
    }
}