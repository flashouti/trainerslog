package ru.npcric.asparagus.trainerslog.service.observer;

import java.util.ArrayList;
import java.util.List;

public class Order implements Subject {
    private List<Observer> observers;
    private String status;

    public Order() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }
}
