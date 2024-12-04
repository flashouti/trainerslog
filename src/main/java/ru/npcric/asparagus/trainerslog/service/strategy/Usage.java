package ru.npcric.asparagus.trainerslog.service.strategy;

public class Usage {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment("1234-5678-9876-5432"));
        context.executePayment(100);

        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.executePayment(200);
    }
}
