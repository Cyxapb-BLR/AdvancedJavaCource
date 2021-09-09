package com.javarussia.test.java.lambda.first;


interface Executable {
    void execute();         // лямбду можно использовать, если только 1 метод в интерфейсе

   // int execute2();
}

class Runner {
    public void run(Executable e) {
        e.execute();
    }
}

class ExecutableImpl implements Executable {

    @Override
    public void execute() {
        System.out.println("Hello");
    }
}

public class Test2 {
    public static void main(String[] args) {
        Runner runner = new Runner();

        runner.run(new ExecutableImpl());              // 1 способ

        runner.run(new Executable() {                  // 2 способ
            @Override
            public void execute() {
                System.out.println("Hello");
            }
        });

        runner.run(() -> System.out.println("Hello"));  // 3 способ
    }
}
