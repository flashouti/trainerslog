package ru.npcric.asparagus.trainerslog.service.requestHandler;

// Реализация паттерна Template Method
abstract class ApiRequestHandler {


    public final void handleRequest() {
        authenticate();
        processRequest();
        sendResponse();
    }

    protected abstract void processRequest();

    private void authenticate() {
        System.out.println("Аутентификация пользователя...");
    }

    protected abstract void sendResponse();
}
