package ru.npcric.asparagus.trainerslog.service.notification;

public class HighPriorityNotification extends Notification {

    public HighPriorityNotification(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send(String message) {
        messageSender.sendMessage("High Priority: " + message);
    }
}
