package ru.npcric.asparagus.trainerslog.service.order;

public class Usage {
    public static void main(String[] args) {
        Order order = new Order();

        order.process();

        order.complete();

        order.complete();

        order.cancel();

        order.process();
    }
}
