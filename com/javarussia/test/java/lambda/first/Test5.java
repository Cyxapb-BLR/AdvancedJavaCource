package com.javarussia.test.java.lambda.first;

import java.util.Random;

interface Executable5 {
    int execute(int x);          // возвращает int и принимает параметр int
}

class Runner5 {
    public void run(Executable5 e) {
        int a = e.execute(10);
        System.out.println(a);
    }
}

public class Test5 {
    public static void main(String[] args) {
        Random random = new Random();
        Runner5 runner = new Runner5();

        runner.run(new Executable5() {
            @Override
            public int execute(int x) {
                return x + random.nextInt(10);
            }
        });

        runner.run((int x) -> x + random.nextInt(10));      //можно писать без int
        runner.run((x -> x + random.nextInt(10)));
        runner.run(x -> x + random.nextInt(10));            //можно не писать лишние скобки, если 1 аргумент только

        runner.run((int x) -> x + 5);
        runner.run((x) -> x + 5);
        runner.run(x -> x + 5);
    }

}
