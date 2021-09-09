package com.javarussia.test.java.lambda.first;

public class Test {
    public static void main(String[] args) {
        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        });*/
        Thread thread= new Thread(()-> System.out.println("Hello")); //написали создание потока через лямбду вместо кода выше
    }
}
