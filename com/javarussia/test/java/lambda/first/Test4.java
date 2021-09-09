package com.javarussia.test.java.lambda.first;

import java.util.Random;

interface Executable4 {
    int execute();          //теперь возвращает int
}

class Runner4 {
    public void run(Executable4 e) {
        int a = e.execute();
        System.out.println(a);
    }
}

public class Test4 {
    public static void main(String[] args) {
        Random random = new Random();
        Runner4 runner = new Runner4();

        runner.run(new Executable4() {
            @Override
            public int execute() {
                System.out.println("Hello");
                System.out.print("Goodbye\nreturn = ");
                return random.nextInt(10);
            }
        });

        runner.run(() -> {
            System.out.println("Hello from lambda");
            System.out.print("Goodbye from lambda\nreturn = ");
            return random.nextInt(10);
        });

        runner.run(() -> random.nextInt(10));       // если надо вернуть случ число

        runner.run(() -> 10);                                //если надо вернуть 10
    }
}
