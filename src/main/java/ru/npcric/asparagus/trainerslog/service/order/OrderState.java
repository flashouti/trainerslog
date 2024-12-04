package ru.npcric.asparagus.trainerslog.service.order;

public interface OrderState {
    void process(Order order);
    void cancel(Order order);
    void complete(Order order);
}
