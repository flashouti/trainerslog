package ru.npcric.asparagus.trainerslog.service.notification;

//Реализация паттерна Builder
public abstract class Notification {
    protected MessageSender messageSender;

    protected Notification(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public abstract void send(String message);
}
