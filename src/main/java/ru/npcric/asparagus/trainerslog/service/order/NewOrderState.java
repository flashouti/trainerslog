package ru.npcric.asparagus.trainerslog.service.order;

public class NewOrderState implements OrderState {
    @Override
    public void process(Order order) {
        System.out.println("Processing the order.");
        order.setState(new InProgressOrderState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cancelling the order.");
        order.setState(new CanceledOrderState());
    }

    @Override
    public void complete(Order order) {
        System.out.println("Cannot complete a new order.");
    }
}
