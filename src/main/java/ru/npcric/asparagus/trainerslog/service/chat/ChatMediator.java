package ru.npcric.asparagus.trainerslog.service.chat;

//Реализация паттерна Mediator
public interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}