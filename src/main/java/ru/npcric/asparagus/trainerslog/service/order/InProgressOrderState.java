package ru.npcric.asparagus.trainerslog.service.order;

public class InProgressOrderState implements OrderState {
    @Override
    public void process(Order order) {
        System.out.println("Order is already in progress.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cancelling the order.");
        order.setState(new CanceledOrderState());
    }

    @Override
    public void complete(Order order) {
        System.out.println("Completing the order.");
        order.setState(new CompletedOrderState());
    }
}
