package ru.npcric.asparagus.trainerslog.service.requestHandler;

public class Usage {
    public static void main(String[] args) {
        ApiRequestHandler getRequestHandler = new GetRequestHandler();
        getRequestHandler.handleRequest();

        System.out.println();

        ApiRequestHandler postRequestHandler = new PostRequestHandler();
        postRequestHandler.handleRequest();
    }
}
