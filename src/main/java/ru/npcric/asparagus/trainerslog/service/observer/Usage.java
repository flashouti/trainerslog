package ru.npcric.asparagus.trainerslog.service.observer;

public class Usage {
    public static void main(String[] args) {
        Order order = new Order();

        User user1 = new User("Alice");
        User user2 = new User("Bob");

        // Подписываем пользователей на изменения статуса заказа
        order.registerObserver(user1);
        order.registerObserver(user2);

        // Изменяем статус заказа
        order.setStatus("Order placed");
        order.setStatus("Order shipped");

        // Удаляем одного из пользователей
        order.removeObserver(user1);

        // Изменяем статус заказа снова
        order.setStatus("Order delivered");
    }
}
