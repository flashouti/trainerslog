package ru.npcric.asparagus.trainerslog.service.order;

public class CanceledOrderState implements OrderState {
    @Override
    public void process(Order order) {
        System.out.println("Cannot process a canceled order.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Order is already canceled.");
    }

    @Override
    public void complete(Order order) {
        System.out.println("Cannot complete a canceled order.");
    }
}