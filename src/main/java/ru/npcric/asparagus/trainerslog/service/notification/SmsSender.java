package ru.npcric.asparagus.trainerslog.service.notification;

public class SmsSender implements MessageSender {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}