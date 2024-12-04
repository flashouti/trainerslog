package ru.npcric.asparagus.trainerslog.service.order;

public class CompletedOrderState implements OrderState {
    @Override
    public void process(Order order) {
        System.out.println("Cannot process a completed order.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cannot cancel a completed order.");
    }

    @Override
    public void complete(Order order) {
        System.out.println("Order is already completed.");
    }
}