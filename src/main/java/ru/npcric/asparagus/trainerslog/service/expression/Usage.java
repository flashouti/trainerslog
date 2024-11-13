package ru.npcric.asparagus.trainerslog.service.expression;

public class Usage {
    public static void main(String[] args) {
        String expression = "5 3 + 2 -";
        Expression parsedExpression = Parser.parse(expression);
        int result = parsedExpression.interpret();

        System.out.println("Результат: " + result);
    }
}
