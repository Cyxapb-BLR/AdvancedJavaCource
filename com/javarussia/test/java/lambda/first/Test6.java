package com.javarussia.test.java.lambda.first;

import java.util.Random;

interface Executable6 {
    int execute(int x, int y);          // возвращает int и принимает 2 параметра int
}

class Runner6 {
    public void run(Executable6 e) {
        int a = e.execute(10, 17);
        System.out.println(a);
    }
}

public class Test6 {
    public static void main(String[] args) {
        Random random = new Random();
        Runner6 runner = new Runner6();
        int a = 4;      //если мы хотим использовать эту переменную в lambda, то она не должна изменяться, должна быть псевдо файнал
        //a = 17;       //если присвоим новое значение, то в lambda будет ошибка с использованием этой переменной
        runner.run(new Executable6() {
            @Override
            public int execute(int x, int y) {
                System.out.println(x + y - a);
                int a = 5;    //в методе мы можем создавать новую переменную с этим именем, в lambda - нельзя
                System.out.println(x + y - a);
                return x + y;
            }
        });
        runner.run(((x, y) -> x + y));      //если несколько аргументов, то они пишутся в ()

        runner.run((x, y) -> x - y + random.nextInt(15));

        runner.run((x, y) -> x + y - a);

        runner.run((x, y) -> {
            int b = 5;      //в lambda можем создать переменные, но переменную "int a" создать не сможем
            return x + y - b;
        });
    }
}
