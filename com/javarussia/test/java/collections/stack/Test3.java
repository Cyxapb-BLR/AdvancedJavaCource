package com.javarussia.test.java.collections.stack;

import java.util.Stack;

public class Test3 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);      //заталкивает элементы в стек
        stack.push(3);
        stack.push(1);

        System.out.println(stack);

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
