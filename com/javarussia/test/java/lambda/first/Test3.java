package com.javarussia.test.java.lambda.first;

interface Executable3 {
    void execute();
}

class Runner3 {
    public void run(Executable3 e) {
        e.execute();
    }
}

public class Test3 {
    public static void main(String[] args) {
        Runner3 runner = new Runner3();

        runner.run(new Executable3() {
            @Override
            public void execute() {
                System.out.println("Hello");
                System.out.println("Goodbye");
            }
        });

        runner.run(() -> {      // нужно ставить {} если несколько строк логики
            System.out.println("Hello");
            System.out.println("Goodbye");
        });
    }
}
