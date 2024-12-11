package ru.npcric.asparagus.trainerslog.service.requestHandler;

class GetRequestHandler extends ApiRequestHandler {

    @Override
    protected void processRequest() {
        System.out.println("Обработка GET-запроса...");
        // Логика обработки GET-запроса
    }

    @Override
    protected void sendResponse() {
        System.out.println("GET-запрос обработан");
    }
}