package com.javarussia.test.java.collections.stack;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);      //заталкивает элементы в стек
        stack.push(3);
        stack.push(1);

        System.out.println(stack);

        System.out.println(stack.pop());    //достает последний элемент из стека и удаляет его из стека
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());    //будет ошибка, потмоу что в стеке не осталось элементов
    }


}
