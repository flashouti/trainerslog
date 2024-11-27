package ru.npcric.asparagus.trainerslog.service.observer;

public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String orderStatus) {
        System.out.println("User " + name + " received order status update: " + orderStatus);
    }
}