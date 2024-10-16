package ru.npcric.asparagus.trainerslog.service.notification;

public class LowPriorityNotification extends Notification {

    public LowPriorityNotification(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send(String message) {
        messageSender.sendMessage("Low Priority: " + message);
    }
}