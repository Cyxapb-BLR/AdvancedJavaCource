package com.javarussia.test.java.collections.stack;

import java.util.Stack;

public class Test2 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);      //заталкивает элементы в стек
        stack.push(3);
        stack.push(1);

        System.out.println(stack);

        System.out.println(stack.peek());    //достает последний элемент из стека и не удаляет его из стека
        System.out.println(stack.peek());   //в итоге извлекся такой же элемент

    }
}
