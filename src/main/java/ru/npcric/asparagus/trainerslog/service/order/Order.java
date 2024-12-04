package ru.npcric.asparagus.trainerslog.service.order;

public class Order {
    private OrderState state;

    public Order() {
        this.state = new NewOrderState(); // Начальное состояние
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void process() {
        state.process(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public void complete() {
        state.complete(this);
    }
}
