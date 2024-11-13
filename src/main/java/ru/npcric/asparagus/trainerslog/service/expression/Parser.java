package ru.npcric.asparagus.trainerslog.service.expression;

import java.util.Stack;

public class Parser {
    public static Expression parse(String expression) {
        Stack<Expression> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.equals("+")) {
                Expression right = stack.pop();
                Expression left = stack.pop();
                stack.push(new AdditionExpression(left, right));
            } else if (token.equals("-")) {
                Expression right = stack.pop();
                Expression left = stack.pop();
                stack.push(new SubtractionExpression(left, right));
            } else {
                stack.push(new NumberExpression(Integer.parseInt(token)));
            }
        }

        return stack.pop();
    }
}